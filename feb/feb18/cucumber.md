## Cucumber

Cucumber is a acceptance test automation framework that allows for the mapping of natural language behavioral definitions (Given... When... Then...) to executable test code.

To begin, add the `cucumber` dependency to your Maven `pom.xml`:

```XML
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit-platform-engine</artifactId>
    <scope>test</scope>
</dependency>
```

Cucumber behavioral definitions are defined using the **Gherkin** language in files with the `.feature` file extension. It uses keywords denoting specific test steps or test parameters.

Within a Gherkin file,

- Define the **Feature** being tested using the `Feature:` keyword.
- Under the feature, specify specific **Scenarios** to test.
- Within the scenario, define in natural language using the following keywords:
  - **Given** - the initial state to provide to the test
  - **When** - the functionality of the feature that you are testing
  - **Then** - the expected behavior of the feature given the state

You can also extend these steps using the **And** and **But** keywords.

All in all, it should look something like this:

```Gherkin
Feature: Is it Friday?
  Scenario: Sunday is not Friday
  Given today is "Sunday"
  When I ask if it is Friday
  Then I should be told "No"
```

Note that if you want to define strings to extract, surround them in quotes: `"` or `'`.

Then, within your test driver, include the following annotations:

```Java
// Tells JUnit to group the tests
@Suite

// Tells to use cucumber
@IncludeEngines("cucumber")

// Tells where to find the step defintions
@SelectClasspathResource("com/example")

// Configs
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCucumberTest {
}
```

Lastly, define a step definition file for your specific feature and include it in the same package as defined within your test driver:

```Java
package com.example;

public class StepDefinitions {
    ...
}
```

Then, use the `@Given()`, `@When()`, and `@Then()` annotations to define methods to execute on the Gherkin steps defined in the feature file.

For each annotation, define the step to match using a **Cucumber Expression**. If it's just a normal string, it'll match exactly the string passed in.

You can also extract out values using `{type}` within the curly braces that can then be passed into your method:

```Java
@Given("today is {string}")
public void todayIs(String today) {
    ...
}
```

The following types are common:

- `{string}`
- `{word}` - captures a single word
- `{int}`
- `{float}`
- `{}` - matches everything

Generally, the methods with the annotations are as follows:

- `@Given()` - Sets up the environment for the feature
- `@When()` - Performs the action on the feature
- `@Then()` - Asserts the behavior is as expected

To more easily define multiple scenarios, we can use **Scenario Outlines**. These act as a sort of template for scenarios we can then substitute variables in for.

- Define variables to substitute using `<var>`

```Gherkin
Scenario Outline: Today is or is not Friday
  Given today is "<day>"
  When I ask if it is Friday
  Then I should be told "<response>"
```

Then, define variables using **Example** definitions using the `Examples:` keyword:

```Gherkin
Examples:
  | day       | response |
  | Sunday    | No       |
  | Monday    | No       |
  | Tuesday   | No       |
  | Wednesday | No       |
  | Thursday  | No       |
  | Friday    | Yes      |
  | Saturday  | No       |
```

The syntax is a table-like where the variable names are defined in the first row followed by a list of values.
