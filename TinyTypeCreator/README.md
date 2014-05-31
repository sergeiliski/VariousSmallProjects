# TinyTypeCreator


## What are Tiny Types?

Tiny Types are, as the name might give away, small types that have the intention to replace the traditional fields in a class. The main motivation behind this is that it makes things clearer for the programmer and reduces possible mistakes. 

Advantages include:

* Compile-time constructor- and method-argument clarity: no more passing the wrong string to your methods.
* Method parameter ordering clarity: You will never accidentally switch two arguments again.
* No conversion problems: a variable that's supposed to keep its price in €'s won't accidentally accept $'s.

For more background on these types, I'd like to refer to some articles:

* Darren Hobbs, Tiny Types, http://darrenhobbs.com/2007/04/11/tiny-types/
* Graham Nash, Tiny-Type Language Support, http://grahamnash.blogspot.be/2011/08/tiny-type-language-support.html

## How does it work?

The way I implemented this is by providing a library which will generate a .dll file for you, creating the types you defined. These types can be defined both programmatically and through an XML file (including a few settings free for your alteration should you wish to change something). 

After building your project you will have a .dll file which you can add to your projects.

###What is supported?

* Reference types will be auto-initialized if there is a parameterless constructor available (including collections like `List<T>`).
* Automatic `.ToString()`, `.Equals(object o)` and `.GetHashCode()` implementations.
* Collections their `.ToString()` returns the collection's contents.
* Logging available.
* Configuration options for the following parameters:

   - Output directory
   - Output language
   - Automatically initializing fields
   - Default field name

* Ability to specify types and settings through an XML file.

## Requirements

As for now, [log4net](https://www.nuget.org/packages/log4net/) is required as an additional dependency. There is no built-in log4net config but you can find one below.

## What's coming next?

* Unit tests.
* Partial class definitions.
* More configuration options for individual Tiny Types (including what methods to generate).
* Constructors with parameter for each type.
* Complex type, comprised of multiple Tiny Types.
* Synonyms for common types in the XML file.
* XSD validation file.
* JSON support.
* Integrated log configuration.
* Operator overloading.

## Resources

### Log4net configuration file

    <configSections>
      <section name="log4net" type="log4net.Config.Log4NetConfigurationSectionHandler, log4net" />
    </configSections>
    
    <log4net>
      <appender name="ReleaseFileAppender" type="log4net.Appender.RollingFileAppender, log4net">
        <file value="C:\\releaselog.txt" />
        <maximumFileSize value="10000KB" />
        <rollingStyle value="Size" />
        <maxSizeRollBackups value="1" />
        <appendToFile value="true" />
    
        <lockingModel type="log4net.Appender.FileAppender+MinimalLock" />
        <layout type="log4net.Layout.PatternLayout">
          <conversionPattern value="%date %level %logger - %message%newline" />
        </layout>
    
        <filter type="log4net.Filter.LevelRangeFilter">
          <levelMin value="INFO" />
          <levelMax value="FATAL" />
        </filter>
      </appender>
    
      <root>
        <level value="ALL" />
        <appender-ref ref="ReleaseFileAppender" />
      </root>
    </log4net>

### XML configuration file

    <?xml version="1.0" encoding="utf-8" ?>
    <ParameterFile>
      <Settings>
        <OutputDirectory>../../../</OutputDirectory>
        <OutputLanguage>C#</OutputLanguage>
        <AutoInitializeFields>true</AutoInitializeFields>
        <DefaultFieldName>Value</DefaultFieldName>
      </Settings>
      
      <TinyTypes>
        <TinyType>
          <Name>FirstName</Name>
          <Type>System.String</Type>
        </TinyType>
    
        <TinyType>
          <Name>LastName</Name>
          <Type>System.String</Type>
        </TinyType>
    
        <TinyType>
          <Name>Age</Name>
          <Type>System.Int32</Type>
        </TinyType>
    
        <TinyType>
          <Name>ImportantListOfNumbers</Name>
          <Type>System.Collections.Generic.List`1[System.Int32]</Type>
        </TinyType>
      </TinyTypes>
    </ParameterFile>
    
    var xml = XDocument.Load("InputTinyTypes.xml");
    var setup = new TinyTypeSetup(xml);
    setup.Compile();
    
### Code configuration sample

    TinyTypeSetup setup = new TinyTypeSetup();
    setup.TinyTypes.Add(new TinyType("FirstName", typeof(string)));
    setup.TinyTypes.Add(new TinyType("LastName", typeof(string)));
    setup.TinyTypes.Add(new TinyType("Height", typeof(int)));
    setup.TinyTypes.Add(new TinyType("ListOfNumbers", typeof(List<int>)));
    setup.Compile();
    
    // Configuration
    var parameters = new TinyTypeSetupParameters();
    parameters.OutputDirectory = "C:\\Test";
    parameters.AutoInitializeFields = false;
    TinyTypeSetup setup = new TinyTypeSetup(parameters);
    
Remaining constructor:

    // Settings are read from the parameter file, TinyTypes from the XML document
    public TinyTypeSetup(TinyTypeSetupParameters, XDocument) 
    
## Walkthrough

1. Create a new console application
2. Add a reference to TinyTypeCreator (direct library or NuGet)
3. Add a reference to log4net
4. Add the following code to your `main` method:

        TinyTypeSetup setup = new TinyTypeSetup();
        setup.TinyTypes.Add(new TinyType("FirstName", typeof(string)));
        setup.TinyTypes.Add(new TinyType("LastName", typeof(string)));
        setup.TinyTypes.Add(new TinyType("Height", typeof(int)));
        setup.TinyTypes.Add(new TinyType("ListOfNumbers", typeof(List<int>)));
        setup.Compile();

5. Go to your output directory (default value: the base directory of your solution)
6. Add your generated library (`TinyTypes.dll`) to a project of your choice


## References

* [NuGet package](https://www.nuget.org/packages/TinyTypeCreator/)
* [Careers 2.0](http://careers.stackoverflow.com/Vannevelj)
* [Stack Overflow](http://stackoverflow.com/users/1864167/jeroen-vannevel)
* [LinkedIn](https://www.linkedin.com/in/Vannevelj)
 


    


