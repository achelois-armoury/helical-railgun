# Helical-railgun

Helical-railgun is a RESTful request shooter to Testrail server upon finished test run. The bullets are contains information that suffice for a test case to be marked with available status(passed, failed, ignored ... etc). A shorthand for any applications to import the result later. Supported Surefire plugin providers are:
  
- Junit
- TestNg
- Spock

## Installation

Example of Junit settng to be done through pom.xml

```xml
        [...]
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

## License
[MIT](https://choosealicense.com/licenses/mit/)