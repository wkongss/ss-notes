### Structs

Structs are just like classes, but are stored on the stack (similar to primitive variables).

```C#
public struct MyStruct
{
    private int _myVal;
    public MyStruct(int value)
    {
        this._myVal = value;
    }
}
```

All fields must be initialized by the constructor.
Additionally, fields may hold references. Although a struct may live on the stack, its references may still be subject to mutation.

### Iterable Collections

Collections implementing the `IEnumerable` interface will have access to `foreach` loop functionality.

These include:

- `List<T>` - Similar to Java's ArrayList. Add elements with `.Add()`, remove with `.Remove()`, sort with `.Sort()`. Access a specific index with `.Item()` or through standard indexing.
- `LinkedList<T>` - Similar to Java's LinkedList. No random indexing.
- `Dictionary<K, V>` - Similar to Java to HashMap. Elements are iterated in insertion order. Add elements with `.Add()`, remove with `.Remove()`. Access a specific index with `.Item()` or through standard indexing.
- `SortedDictionary<K, V>` - Similar to Java's TreeMap. Elements are iterated in sorted order.
- `HashSet<T>` - Similar to Java's HashSet. Add elements with `.Add()`, remove with `.Remove()`. Check if the set contains an element with `.Contains()`.
- `Queue<T>` - Similar to Java's `Queue`. Add with `.Enqueue()` and pop with `.Dequeue()`.

### Generics

Generics allow you to define your classes to work with generic types. To do so, define the types in angle brackets:

```C#
public class MyGenericClass<T>
{
    private T _genericValue;
    public MyGenericClass(T genericValue)
    {
        this._genericValue = genericValue;
    }
}
```

### File I/O

The `File` static class lets you access methods to handle File I/O.

Read files with:

- `File.ReadAllText(string path)` - Reads the entirety of the file as a single string value. Bad for large files.
- `File.ReadAllLines(string path)` - Reads the entirety of the file as an array of strings denoting each line.
- Via a `new StreamReader(string path)` - Use `reader.ReadLine()` to read the next line if any. Can be handled with auto-managed contexts with the `using` keyword to handle opening and closing the file:

```C#
using(StreamReader reader = new StreamReader("C://doc.txt"))
{
    while (!reader.EndOfStream)
    {
        Console.WriteLine(reader.readLine());
    }
}
```

To write to a file, use the StreamWriter:

```C#
using(StreamWriter writer = File.AppendText("C://doc.txt"))
{
    writer.WriteLine("Hello World!");
}
```

### Configs

Define key-value configurations in an `XML` config file:

```XML
<configuration>
    <appSettings>
        <add key="Key" value="Value" />
    </appSettings>
</configuration>
```

Then, use the static `ConfigurationManager` to access your config values as strings:

```C#
string myValue = ConfigurationManager.AppSettings.Get("Key");
```

### IComparable and IComparer

To enable sorting for custom classes, implement the `IComparable<T>` interface. To do so, you need to override the `CompareTo(T another)` method that returns a negative value for before and a positive value for after in terms of sorted order:

```C#
public class MyClass: IComparable<MyClass>
{
    public int CompareTo(MyClass other)
    {
        return this.ToString().CompareTo(other.ToString());
    }
}
```

Similarly, the `IComparer<T>` interface lets you define a single method class that compares two objects of type `T` via the `Compare(T obj1, Tobj2)` method:

```C#
public class MyClassComparer: IComparer<MyClass>
{
    public int Compare(MyClass obj1, MyClass obj2)
    {
        return String.Compare(obj1, obj2);
    }
} 
```