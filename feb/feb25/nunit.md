## NUGet

This is C#'s package manager similar to `npm` or `pip`. It finds and downloads dependencies while handling versions and subdependencies.

Similar to Maven's dependency manager, it stores dependencies locally as well as pulling from a [remote repository](https://nuget.org).
Project dependencies are then listed in the `.csproj` file.

## NUnit

NUnit is C#'s go-to unit testing framework.
To begin, install with NUGet in VSCode, VS, or via the command line:

```bash
dotnet package add nunit
```

Afterwards, define a class to put your tests in.

### Attributes

NUnit uses C# Attributes in order to organize a testing suite.
Mark any method intended to be used as a test with the `[Test]` attribute:

```C#
public class Tests
{
    [Test]
    public void MyTest()
    {
        ...
    }
}
```

Additional attributes can be found here: https://docs.nunit.org/articles/nunit/writing-tests/attributes.html

You can mark setup and teardown methods with the `[OneTimeSetup]`, `[SetUp]`, `[TearDown]`, and `[OneTimeTearDown]` attributes.
These OneTimeSetup runs once at the beginning of the suite, Setup runs before every test, Teardown runs after every test, and OneTimeTeardown runs after the entire suite has concluded:

```C#
[SetUp]
public void MySetup()
{
    Console.WriteLine("Before every test");
}

[TearDown]
public void MyTeardown()
{
    Console.Writeline("After every test");
}
```

### Assertions

NUnit comes with many built-in assertions that we can use to test our code. Access them from the static `Assert` class:

 - `Assert.That(bool)` - Asserts that the input is true.
 - `Assert.Equals(val1, val2)` - Assert that the two values are equal.
 - `Assert.Throws<ExceptionType>(function)` - Asserts that a particular exception is thrown.
 - `Assert.Pass()` - Passes the test
 - `Assert.Fail()` - Fails the test

In newer versions, all of this can be done using `Assert.That` and passing in a `Has` or `Is` modifier as the second argument.

Reference: https://docs.nunit.org/articles/nunit/writing-tests/assertions/assertions.html

### Running Tests

The .NET runtime has built-in testing support. To build and run your project tests, use:

```bash
dotnet test
```
