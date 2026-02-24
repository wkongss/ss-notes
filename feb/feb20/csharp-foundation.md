## C#

C# is a language part of the **.NET Core** cross-platform ecosystem (including F# and Visual BASIC) that uses the .NET runtime.

**.NET Framework** is a legacy implementation for Windows operating systems.
**.NET Standard** is a bridge between Framework and Core.

C# is compiled, so to compile your program, use `dotnet build`. To compile and run your program

### Variable Declaration

Similar to Java, C# is a statically-typed language where the variable types are known at compile time. It has multiple built-in types including:

```C#
// Boolean types
bool myBoolean = false;

// Integral types
byte myByte = 255;
short myShort = 32_000;
int myInt = 2_000_000;
long myLong = 9_000_000_000_000_000_000;

// Floating point types
float myFloat = 2.0f;
double myDouble = 2.0;
decimal myDecimal = 2.0m;

// Characters and strings
char myChar = 'a';
string myString = "abc"; // <- reference type

// Object
object myObject; // <- reference type
```

Note that unlike Java, characters are *not* integral types and must be explicitly converted for operations.

For locally-scoped variables, we can let C# infer their type using the `var` keyword.

### Classes

C# is object-oriented and contains the general notion of classes.

Define them like so:

```C#
public class MyClass 
{
    ...
}
```

Classes can have fields and methods.
Define fields with their type and additional modifiers:

```C#
public class MyClass 
{
    private string _myField;
    // Implicit getters/setters -v
    public string MyString { get; set; };
}
```

By convention, name private fields with a leading underscore and public properties with PascalCase.

Fields may have additional modifiers:
 - `public` (everyone), `private` (class body), `protected` (class and all subclasses) for access modifiers.
 - `static` within memory and does not need class instantiation
 - `readonly` - cannot be overwritten - evaluated at runtime. 
 - `const` - implicitly static and evaluated compile time.
 - `required` - must be set on object initialization

You can also define methods within the class body.
Similar to fields, they can have modifiers:
 - `public`, `private`, `protected`
 - `return type`/`void` - the type the method returns.
 - `virtual` - overridable method with a possible default implementation
 - `abstract` - mandatory overridable method with no default implementation
 - `override` - overrides a virtual or abstract method.

Classes can also be `abstract`, meaning they cannot be instantiated and can contain abstract methods.

**Interfaces** are also a feature of C#. define them with

```C#
public interface IActionable 
{
    ...
}
```

They contain contract properties and methods that implementing classes must implement. In older versions, said methods couldn't have default implementations, but now they can!

To inherit from a class or interface, use `: Class/Interface` when defining your subclass. For multiple interfaces, separate by commas:

```C#
public class MyClass : MyParentClass, IActionable1, IActionable2 {
    ...
}
```

Create a constructor by defining a `public` method with the same name as your class.
To call a parent class' constructor, use the following syntax:
```C#
public MyClass(int num) : base(num)
{
    ...
}
```

Then, instantiate them with the `new` keyword just like in JS or Java:

```C#
MyClass classInstance = new MyClass();
```

Unlike Java, you can also use keyword fields in an **Object Initializer**. Any required fields would also be set here:

```C#
MyClass objectInitializerInstance = new MyClass { Name = "Bob" };
```

### Verbatim and Interpolated Strings

C# has verbatim strings denoted with `@""` and will simply record strings as-is including white spice, new lines, quotes, slashes, etc.

```C#
var myString = @"This
will
have
newlines record!";
```

You can also interpolated strings using `$""`, where literals and variables between braces (`{}`) are interpolated:

```C#
int age = 42;
string name = "John";

Console.WriteLine($"Hi my name is {name} and I'm {age} years old!");
```

Note that these can be combined together with `$@""`.

### Arrays

Declare an array with `type[] arrName = new type[size]`.
Index arrays with `arrName[index]`.

### Loops

C# also has all of our favorite loops!

For loop:

```C#
for (int i = 0; i < numIters; i++) 
{
    ...
}
```

While loop:

```C#
while (condition)
{
    ...
}
```

Do While loop:

```C#
do
{

} while(condition)
```

For Each loop:

```C#
foreach (type v in typeIterable)
{
    ...
}
```

### Exception Handling

Use `try-catch` statements to handle exceptions:

```C#
try
{
    ...
}
catch (ExceptionType e)
{
    ...
}
catch (AnotherExceptionType e)
{
    ...
}
finally
{
    ...
}
```

You can throw exceptions with the `throw` keyword followed by an instance of an `Exception` object.

To create a custom exception, inherit from the base `Exception` and define three constructors:
 - `MyException() { ... }`
 - `MyException(string message) { ... }`
 - `MyException(string message, Exception innerException) { ... }`

### Some Quirks

 - While C# has garbage collection, it still inherits pointers from C. To access the pointer of a variable, use the `ref` keyword before the variable name.
 - Reference type variables are passed by reference; on the other hand, primitives are passed by value.
 - The `namespace` defines the "package" the file belongs to. Within a namespace, you can share references without directly importing.
 - To import outside of a namespace, use the `using` keyword followed by the library name.