## TestNG

TestNG is an automated testing framework built on NUnit and JUnit and serves to offer a better testing experience for component and end-to-end testing.

It offers many nice-to-have features including customizable conditional testing via **groups**, a logical hiearchy of test categorization, and expanded annotation library.

Start by adding the dependency to your `pom.xml`:

```XML
<!-- Source: https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.12.0</version>
    <scope>test</scope>
</dependency>
```

### Annotations

TestNG organizes tests into a logical hiearchy from highest to lowest:

- **Suite** - This is the overall set of tests you wish to run. Contains tests.
- **Test** - A grouping of test classes within a suite.
- **Class** - A class containing test methods.
- **Methods** - A method that performs a behavioral test. Tagged with the `@Test` annotation.

Tests themselves can also be tagged with a specific group separate from the hiearchy. They can cross multiple tests, classes, and methods.

We can then create setup and teardown methods to tap into the lifecycle:

- `@BeforeSuite` will run before suite initialization
- `@BeforeTest` will run before each test grouping within the suite
- `@BeforeClass` will run before class initialization within each test grouping.
- `@BeforeMethod` will run before each test method within each class.
- `@Test` methods will run after all setup is complete
- `@AfterMethod` cleans up after a method is complete.
- `@AfterClass` cleans up after a class is finished.
- `@AfterTest` cleans up after a test group is finished.
- `@AfterSuite` cleans up after the suite is finished running.

- `@BeforeGroups` and `@AfterGroups` will run before the first method of a group runs and after the last method of a group runs respectively.

To mark an individual test, use the `@Test` annotation. Additionally, you can specify certain keyword attributes within the annotation:

- `enabled` - set to a boolean value and controls whether the test runs or not.
- `groups` - set to an array literal and contains the groups the test is a part of.
- `priority` - set to an integer and controls test scheduling (lowest priority are first). Otherwise, test order is undefined.
- `timeOut` - sets a time limit in `ms` before the test times out

```Java
import org.testng.annotations.*;

@Test(
    priority = 0,
    groups = { "regression", "functest" }
    timeOut = 1000,
    enabled = false
)
public void myTest() {
    ...
}
```

Reference: https://testng.org/#_annotations

### Assertions

TestNG also provides assertions that mirror JUnit's assertion library. Import them using the package

```Java
import static org.testng.Assert.*
```

Then you can use the static methods `Assert.assertEquals(actual, expected), assertTrue(bool), assertFalse(bool), assertNull(value)`

Note that all of these methods have an additional parameter in which you can display a failure message:

```Java
@Test()
public void myTest() {
    assertEquals(getCubeSides(), 6, "Number of sides not equal to 6");
}
```

Reference: https://testng.org/#_test_results

### The `testng.xml` File

The `testng.xml` file allows us to orchestrate an entire test suite and define which tests to run (and their location) as well as parallelization options, parameters, and configurations.

Overall, it'll look something like this, maintaining the Suite Test Class/Package hiearchy:

```XML
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="Suite1" verbose="1">
  <test name="Nopackage">
    <classes>
       <class name="NoPackageTest"/>
    </classes>
  </test>

  <test name="Regression1">
    <classes>
      <class name="test.sample.ParameterSample"/>
      <class name="test.sample.ParameterTest"/>
    </classes>
  </test>
</suite>
```

To define parallization, include the `parallel` method in your suite tag and set it equal to the level of parallization: `tests`, `classes`, or `methods`.

Add the `testng.xml` path to your Maven Surefire Plugin config in your `pom.xml` to run it in the testing phase:

```XML
<plugin>
  <artifactId>maven-surefire-plugin</artifactId>
  <version>3.2.5</version>
  <configuration>
    <suiteXmlFiles>
        <suiteXmlFile>
            src/test/resources/testng.xml
        </suiteXmlFile>
    </suiteXmlFiles>
</configuration>
</plugin>
```

Reference: https://testng.org/#_testng_xml

### Generating Test Reports

TestNG allows for the automatic generation of test reports in the `xml` format. You can then add an additional dependency in our `pom.xml` file to generate nicer-looking reports:

```XML
<!-- Source: https://mvnrepository.com/artifact/org.testng/reportng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>reportng</artifactId>
    <version>1.2.2</version>
    <scope>compile</scope>
</dependency>
```

The output will be in your `test-output` directory. There, you will find an `xml` directory containg the test results as well as an `html` directory containing the pretty results.
