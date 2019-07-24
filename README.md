# Helical-railgun [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.achelois-armoury/helical-railgun/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.achelois-armoury/helical-railgun/) [![Build Status](https://dev.azure.com/achelois/helical-railgun/_apis/build/status/achelois-armoury.helical-railgun?branchName=master)](https://dev.azure.com/achelois/helical-railgun/_build/latest?definitionId=1&branchName=master) [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://choosealicense.com/licenses/mit/)
![alt text](https://images.squarespace-cdn.com/content/v1/55a1e994e4b0b796f1ff0572/1559676034326-QIFVQ5KV4FQT8FTBGLDI/ke17ZwdGBToddI8pDm48kBJcEoGlYmIb8eXE31ZaxCN7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0oCA_6zAHQKJnM6yePSW5pSPMoXiKHmdEPIp1wwI8ycCBXVndLtUShlyYbZz1iBDgw/RailGun_BluePrint_001a.png?format=2500w)

Helical-railgun is a RESTful request shooter to Testrail server upon finished test run. The bullets are contains information that suffice for a test case to be marked with available status(passed, failed, ignored ... etc). A shorthand for any applications to import the result later. Supported Surefire plugin providers are:
  
- Junit
- TestNg
- Spock

## Installation

Example of Junit setting to be done through pom.xml

```xml
        <plugins>
        [...]      
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <configuration>
                    <properties>
                        <property>
                            <name>listener</name>
                            <value>com.achelois.helical.Junit4Listener</value>
                        </property>
                    </properties>
                </configuration>
            </plugin>
        [...]
        </plugins>
```

## Usage

```java
import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.annotations.RunId;

@RunId(11)
class TestClassA {
    @CaseId(6)
    public void testSimplifiedStub(){
        // your test codes here ...
    }    
}
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.