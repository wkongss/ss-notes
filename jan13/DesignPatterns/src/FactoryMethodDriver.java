public class FactoryMethodDriver {
    public static void main(String[] args) {
        // The factory method design pattern is to increase class cohesion and decrease coupling
        // Cohesion is when the focus of a class is on a single thing.
        // Coupling is when classes have dependencies on each other.

        // Cohesion is achieved by having dedicated methods/classes for instantiation
        // Decoupling is via the delegation of specific behaviors to specific subclasses
        // to pair alongside the specific use cases
        
        // Creators are responsible for defining the product they instantiate.
        PuzzleStore puzzlesRUs = new PuzzleStore();
        FigureStore dollHouse = new FigureStore();

        // Object (concrete product) creation is delegated to either a dedicated
        // factory class like ToyFactory or more commonly, a subclass of the creator (extends ToyStore)
        // To follow inheritence, the products must be a subclass of a shared
        // ancestor class
        Toy puzzle = puzzlesRUs.getProduct();
        Toy doll = dollHouse.getProduct();

        // Use polymorphism to achieve subclass-agnostic behavior
        puzzle.play();
        doll.play();
    }
}
