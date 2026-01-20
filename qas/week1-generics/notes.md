### Type Generics

**Problem**: we need type flexibility for classes to handle multiple types
    - Naive solution: create a class that handles each type

    - Potential solution: Every class is a subclass of the Object class. We can simply use the most generic
        - Issues: Difficulties with type safety


#### Generics

**Basic principle**: Generics are types as a parameter. This allows classes to maintain type safety while allowing users to use a single class to handle flexibly handle types.

Syntax: we can define a generic type parameter in one of two places:
    1. Class definition:
```Java
public class GenericClass<T> {
    ...
}
```
    2. Method definitions:
```Java
public <T> void method() {
    ...
}
```

We've already seen these with collections (i.e. ArrayList, HashMap)!

#### Wildcards

When you don't need to know the type itself (i.e. a return type), instead, we just need to write code that works whatever it is.
Primarily to get around non covariant relationships.

CANNOT BE USED AS A TYPE ITSELF

Type bounding:

We can constrain generic type parameters using the extends keyword (supports multiple constraints), but only upper bound constraints.
    - Example:
```Java
public class Coordinates<T extends Number> {
    ...
}
```

Wildcards also support the super constraints (lower bound constraints).