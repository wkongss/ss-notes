public abstract class ToyStore {
    private String address = "";

    public ToyStore() {

    }

    public ToyStore(String address) {
        this.address = address;
    }

    public abstract Toy getProduct();
}

class PuzzleStore {
    public PuzzleStore() {
        super();
    }

    public Toy getProduct() {
        return new JigsawPuzzle(50);
    }
}

class FigureStore {
    public FigureStore() {
        super();
    }

    public Toy getProduct() {
        return new Doll(10.99, "Dolly");
    }
}