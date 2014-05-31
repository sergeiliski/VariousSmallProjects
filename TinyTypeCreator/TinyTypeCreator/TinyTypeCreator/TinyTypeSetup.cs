using System;
using System.CodeDom;
using System.CodeDom.Compiler;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Xml;
using System.Xml.Linq;
using log4net;

namespace TinyTypeCreator
{
    public class TinyTypeSetup
    {
        private static readonly ILog Log = LogManager.GetLogger(MethodBase.GetCurrentMethod().DeclaringType);
        private readonly TinyTypeSetupParameters _parameters = new TinyTypeSetupParameters();
        private FileInfo _generatedFileInfo;

        public TinyTypeSetup()
        {
            TinyTypes = new List<TinyType>();
        }

        public TinyTypeSetup(TinyTypeSetupParameters parameters) : this()
        {
            _parameters = parameters;
        }

        // This constructor will disregard any settings defined in the XML
        public TinyTypeSetup(TinyTypeSetupParameters parameters, XDocument xml) : this(parameters)
        {
            LoadXmlTypes(xml);
        }

        public TinyTypeSetup(XDocument xml) : this()
        {
            _parameters = new TinyTypeSetupParameters();
            _parameters.AddXmlConfiguration(xml);
            LoadXmlTypes(xml);
        }

        private void LoadXmlTypes(XDocument xml)
        {
            var root = xml.Root;
            if (root == null)
            {
                throw new XmlException("There must be a root element \"ParameterFile\" available.");
            }

            var types = root.Elements("TinyTypes");
            if (types == null)
            {
                throw new XmlException("Could not find element \"TinyTypes\".");
            }

            foreach (var tinyType in types.Elements("TinyType"))
            {
                var name = tinyType.Element("Name");
                var type = tinyType.Element("Type");
                if (name == null || type == null)
                {
                    throw new XmlException("A TinyType has to have a Name and Type field.");
                }

                var parsedType = Type.GetType(type.Value);
                if (parsedType == null)
                {
                    throw new XmlException("The value of XML element Type should be a valid fully-qualified type name.");
                }

                TinyTypes.Add(new TinyType(name.Value, parsedType));
            }
        }

        public void Compile()
        {
            Log.Info(_parameters);
            var ttNamespace = new CodeNamespace("TinyTypes");

            TinyTypes.ForEach(x => CompileType(x, ref ttNamespace));
            GenerateDll(ttNamespace);
        }

        private void CompileType(TinyType type, ref CodeNamespace ttNamespace)
        {
            var newType = new CodeTypeDeclaration(type.Name)
            {
                TypeAttributes = TypeAttributes.Public
            };

            var newField = new CodeMemberField(type.Type, _parameters.DefaultFieldName)
            {
                Attributes = MemberAttributes.Public
            };

            if (_parameters.AutoInitializeFields)
            {
                SetInitialization(ref newField, type);
            }

            AddEqualsMethod(ref newType, type);
            AddGetHashCodeMethod(ref newType);
            AddToStringMethod(ref newType, type);

            newType.Members.Add(newField);
            ttNamespace.Types.Add(newType);
        }

        private void AddEqualsMethod(ref CodeTypeDeclaration type, TinyType tinyType)
        {
            // Create method
            var method = new CodeMemberMethod
            {
                Name = "Equals",
                Attributes = MemberAttributes.Public | MemberAttributes.Override,
                ReturnType = new CodeTypeReference(typeof (bool)),
            };
            method.Parameters.Add(new CodeParameterDeclarationExpression(typeof (object), "o"));

            // Reference to the null value
            var nullValue = new CodeDefaultValueExpression(new CodeTypeReference(typeof (object)));

            // Check if the argument is null
            var isArgumentNull = new CodeBinaryOperatorExpression
            {
                Left = new CodeArgumentReferenceExpression("o"),
                Operator = CodeBinaryOperatorType.IdentityEquality,
                Right = nullValue
            };

            // null condition
            var nullCondition = new CodeConditionStatement(isArgumentNull);
            nullCondition.TrueStatements.Add(new CodeMethodReturnStatement(new CodePrimitiveExpression(false)));

            // Check for type equality
            var isTypeEqual = new CodeBinaryOperatorExpression
            {
                Left = new CodeMethodInvokeExpression(new CodeThisReferenceExpression(), "GetType"),
                Operator = CodeBinaryOperatorType.IdentityEquality,
                Right = new CodeMethodInvokeExpression(new CodeArgumentReferenceExpression("o"), "GetType")
            };

            var equalityCondition = new CodeConditionStatement {Condition = isTypeEqual};

            // Cast Object to the correct type
            var tempVar = new CodeVariableDeclarationStatement(tinyType.Name, "tmp");
            var cast = new CodeCastExpression
            {
                TargetType = new CodeTypeReference(tinyType.Name),
                Expression = new CodeArgumentReferenceExpression("o")
            };
            tempVar.InitExpression = cast;

            // Add return check on the .Value property
            var trueCondition = new CodeBinaryOperatorExpression
            {
                Left = new CodeFieldReferenceExpression(new CodeThisReferenceExpression(), _parameters.DefaultFieldName),
                Operator = CodeBinaryOperatorType.IdentityEquality,
                Right = new CodePropertyReferenceExpression(new CodeVariableReferenceExpression("tmp"), _parameters.DefaultFieldName)
            };

            // Add to return condition
            var trueReturn = new CodeMethodReturnStatement(trueCondition);

            // Add elements to true-if-body
            equalityCondition.TrueStatements.Add(tempVar);
            equalityCondition.TrueStatements.Add(trueReturn);

            // Add checks to method
            method.Statements.Add(nullCondition);
            method.Statements.Add(equalityCondition);

            // Fallthrough return statement
            method.Statements.Add(new CodeMethodReturnStatement(new CodePrimitiveExpression(false)));
            type.Members.Add(method);
        }

        private void AddGetHashCodeMethod(ref CodeTypeDeclaration type)
        {
            var method = new CodeMemberMethod
            {
                Name = "GetHashCode",
                Attributes = MemberAttributes.Public | MemberAttributes.Override,
                ReturnType = new CodeTypeReference(typeof (int))
            };

            // Each TinyType has only 1 field so we can just return that field's HashCode
            var returnStatement = new CodeMethodReturnStatement();
            var field = new CodeFieldReferenceExpression(new CodeThisReferenceExpression(), _parameters.DefaultFieldName);
            var invocation = new CodeMethodInvokeExpression(field, "GetHashCode");
            returnStatement.Expression = invocation;

            method.Statements.Add(returnStatement);
            type.Members.Add(method);
        }

        private void AddToStringMethod(ref CodeTypeDeclaration type, TinyType tinyType)
        {
            // Create new method
            var newMethod = new CodeMemberMethod
            {
                Name = "ToString",
                ReturnType = new CodeTypeReference(typeof (string)),
                Attributes = MemberAttributes.Public | MemberAttributes.Override
            };

            // Setup return statement
            var returnStatement = new CodeMethodReturnStatement();
            

            // Dealing with a collection => Iterate over the values to construct it using string.Join
            // If it's a string, let it fall through to the direct .ToString() invocation
            if (typeof (IEnumerable).IsAssignableFrom(tinyType.Type) && tinyType.Type != typeof (string))
            {
                var delimiter = new CodePrimitiveExpression(", ");
                var fieldRef = new CodeFieldReferenceExpression(new CodeThisReferenceExpression(), _parameters.DefaultFieldName);
                var invoke = new CodeMethodInvokeExpression(
                                new CodeTypeReferenceExpression(typeof (string)),
                                "Join",
                                new CodeExpression[]
                                {
                                    delimiter,
                                    fieldRef
                                }
                    );

                returnStatement.Expression = invoke;
            }
            else // All other types, including string
            {
                var reference = new CodeMethodReferenceExpression
                {
                    TargetObject = new CodeFieldReferenceExpression(new CodeThisReferenceExpression(), _parameters.DefaultFieldName),
                    MethodName = "ToString()"
                };
                returnStatement.Expression = reference;
            }

            newMethod.Statements.Add(returnStatement);
            type.Members.Add(newMethod);
        }

        private void SetInitialization(ref CodeMemberField field, TinyType type)
        {
            if (type.Type == typeof (string))
            {
                field.InitExpression = new CodePrimitiveExpression("");
            }
            else if (type.Type.IsPrimitive)
            {
                field.InitExpression = new CodeDefaultValueExpression(new CodeTypeReference(type.Type));
            } 
            else
            {
                // Check for a parameterless constructor
                if (type.Type.GetConstructors().Any(x => x.GetParameters().Count() == 0))
                {
                    field.InitExpression = new CodeObjectCreateExpression(new CodeTypeReference(type.Type),
                    new CodeExpression[] { });
                }
            }
        }

        private void GenerateDll(CodeNamespace ttNamespace)
        {
            _generatedFileInfo = new FileInfo(_parameters.OutputDirectory + "TinyTypes.dll");
            var parameters = new CompilerParameters
            {
                GenerateExecutable = false,
                OutputAssembly = _generatedFileInfo.FullName
            };

            var ccUnit = new CodeCompileUnit();
            ccUnit.Namespaces.Add(ttNamespace);

            var provider = CodeDomProvider.CreateProvider(_parameters.OutputLanguage);

#if DEBUG
            // Intermediate output to textfile
            using (var writer = new StreamWriter(@"C:\test.txt"))
            {
                provider.GenerateCodeFromCompileUnit(ccUnit, writer, new CodeGeneratorOptions());
            }
#endif

            var result = provider.CompileAssemblyFromDom(parameters, ccUnit);
            LogCompileResult(result);
        }

        private void LogCompileResult(CompilerResults result)
        {
            if (result.Errors.HasErrors || result.Errors.HasWarnings)
            {
                for (var i = 0; i < result.Errors.Count; i++)
                {
                    var currentError = result.Errors[i];
                    var logMessage = string.Format("{0}: {1} At line {2}, column {3} in {4}", currentError.ErrorNumber,
                        currentError.ErrorText, currentError.Line, currentError.Column, currentError.FileName);
                    if (currentError.IsWarning)
                    {
                        Log.Warn(logMessage);
                    }
                    else
                    {
                        Log.Error(logMessage);
                    }
                }
                return;
            }

            Log.Info("Class library generated at location " + _generatedFileInfo.FullName);
            Log.Info("Generated types:");
            foreach (var type in TinyTypes)
            {
                Log.Info(type);
            }
        }

        public List<TinyType> TinyTypes { get; set; }
    }
}