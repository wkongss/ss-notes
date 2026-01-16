// Analog to a Python dataclass
// Cannot extend classes, but can implement interfaces
public record UserRecord (
    // All fields are implicitly private final
    String id,
    String name,
    String email,
    int joinYear
) {
    // constructor is implicitly-defined for us

    // equals(), hashCode(), and toString() are also implicitly defined

    // Constructors and methods can also be explicitly defined or overwritten; however,
    // this is generally considered to be bad practice.
}
