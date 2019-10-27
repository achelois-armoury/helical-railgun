# Helical-railgun [![Build Status](https://dev.azure.com/achelois/helical-railgun/_apis/build/status/achelois-armoury.helical-railgun?branchName=master)](https://dev.azure.com/achelois/helical-railgun/_build/latest?definitionId=1&branchName=master) [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://choosealicense.com/licenses/mit/)
![alt text](https://images.squarespace-cdn.com/content/v1/55a1e994e4b0b796f1ff0572/1559676034326-QIFVQ5KV4FQT8FTBGLDI/ke17ZwdGBToddI8pDm48kBJcEoGlYmIb8eXE31ZaxCN7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0oCA_6zAHQKJnM6yePSW5pSPMoXiKHmdEPIp1wwI8ycCBXVndLtUShlyYbZz1iBDgw/RailGun_BluePrint_001a.png?format=2500w)

Helical-railgun is a RESTful request shooter to Testrail server upon finished test run. The bullets are contains information that suffice for a test case to be marked with available status(passed, failed, ignored ... etc). A shorthand for any applications to import the result later. Supported Surefire plugin providers are:
  
- Junit 4
- TestNg 6
- Spock 2.4

## Getting Started
These instructions will get your java project up and running with existing Junit4 or Spockframeowrk setup.

### Prerequisites
Prepare a properties file which contains your valid Testrail server information under test resources directory named "testrail.yml".

```yaml
enable: true
endpoint: "https://replaceme.io"
username: "replaceme@gmail.com"
password: "your_api_key_or_password"
runid: 7

result_template:
  status: 4
  version: "0.1.1-SNAPSHOT"
  comment: "test has not executed"
```
### Installations

#### Example of Junit4 and spockframework with Junit setting
```xml
<dependency>
    <groupId>io.github.achelois-armoury</groupId>
    <artifactId>helical-junit4</artifactId>
    <version>0.1.6</version>
    <scope>test</scope>
</dependency>
```

```xml 
<plugins>
[...]      
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <configuration>
            <includes>
                <include>**/*Spec.java</include>
                <include>**/*Test.java</include>
            </includes>
            <properties>
                <property>
                    <name>listener</name>
                    <value>com.achelois.helical.junit4.Junit4Listener</value>
                </property>
            </properties>
        </configuration>
    </plugin>
[...]
</plugins>
```

#### Pure Spockframework setting
```xml
<dependency>
    <groupId>io.github.achelois-armoury</groupId>
    <artifactId>helical-core</artifactId>
    <version>0.1.8</version>
    <scope>test</scope>
</dependency>
```
1. Create a new directory META-INF/services in your project resources folder.
2. Create a new file org.spockframework.runtime.extension.IGlobalExtension in the newly created directory

3. Add following content into the newly created file
```text
com.achelois.helical.plugins.spock.SpockGlobalListenerExt
```

#### TestNG setting
```xml
<dependencies>
    [...]
    <dependency>
        <groupId>io.github.achelois-armoury</groupId>
        <artifactId>helical-testng</artifactId>
        <version>0.1.6</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <configuration>
        <includes>
            <include>**/*.java</include>
        </includes>
        <properties>
            <property>
                <name>listener</name>
                <value>com.achelois.helical.TestngListener</value>
            </property>
        </properties>
    </configuration>
</plugin>
```

## Running the tests
Given a set of valid test-case id(s), mark them into your test class so the result will be updated to the Testrail once it finishes the run.
### In you test class
```java
import com.achelois.helical.annotations.CaseId;

class TestClassA {
    @CaseId(6)
    public void testSimplifiedStub(){
        // your test codes here ...
    }    
}
```

for groovy
```groovy
import com.achelois.helical.annotations.CaseId
import spock.lang.Specification

class MessageServiceSpec extends Specification {

    @CaseId(7)
    def "Get message"() {

        expect: true
    }

}
```

### Execution
```shell script
mvn clean test
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

### Versioning
We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/achelois-armoury/helical-railgun/tags). 
