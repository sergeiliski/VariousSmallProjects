using System;
using System.Text;
using System.Xml;
using System.Xml.Linq;

namespace TinyTypeCreator
{
    public class TinyTypeSetupParameters
    {
        // Outputdirectory defaults to the project's main directory
        private string _outputDirectory = "../../../";
        private string _outputLanguage = "C#";
        private bool _autoInitializeFields = true;
        private string _defaultFieldName = "Value";

        internal void AddXmlConfiguration(XDocument settings)
        {
            var root = settings.Root;
            if (root == null)
            {
                throw new XmlException("There must be a root element \"ParameterFile\" available.");
            }

            var prefs = root.Element("Settings");
            if (prefs == null)
            {
                throw new XmlException("Could not find element \"Settings\".");
            }

            var outputDir = prefs.Element("OutputDirectory");
            if (outputDir != null)
            {
                _outputDirectory = outputDir.Value;
            }

            var outputLang = prefs.Element("OutputLanguage");
            if (outputLang != null)
            {
                _outputLanguage = outputLang.Value;
            }

            var initFields = prefs.Element("AutoInitializeFields");
            if (initFields != null)
            {
                bool success;
                _autoInitializeFields = Boolean.TryParse(initFields.Value, out success);

                if (!success)
                {
                    throw new XmlException("XML entry AutoInitializeFields could not be recognized as a boolean value.");
                }
            }

            var fieldName = prefs.Element("DefaultFieldName");
            if (fieldName != null)
            {
                _defaultFieldName = fieldName.Value;
            }
        }

        public string OutputDirectory
        {
            get { return _outputDirectory; }
            set { _outputDirectory = value; }
        }

        public string OutputLanguage
        {
            get { return _outputLanguage; }
            set { _outputLanguage = value; }
        }

        public bool AutoInitializeFields
        {
            get { return _autoInitializeFields; }
            set { _autoInitializeFields = value; }
        }

        public string DefaultFieldName
        {
            get { return _defaultFieldName; }
            set { _defaultFieldName = value; }
        }

        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.AppendLine(string.Format("{0}: {1}", "OutputDirectory", OutputDirectory));
            sb.AppendLine(string.Format("{0}: {1}", "OutputLanguage", OutputLanguage));
            sb.AppendLine(string.Format("{0}: {1}", "AutoInitializeFields", AutoInitializeFields));
            sb.Append(string.Format("{0}: {1}", "DefaultFieldName", DefaultFieldName));
            return sb.ToString();
        }
    }
}
