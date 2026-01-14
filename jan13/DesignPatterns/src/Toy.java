public abstract class Toy {
    private double price;
    private int minAge;

    public Toy(double price, int minAge) {
        this.price = price;
        this.minAge = minAge;
    } 
    
    public abstract void play();
}

class JigsawPuzzle extends Toy {
    private int numPieces;

    public JigsawPuzzle(int numPieces) {
        super(0.05 * numPieces, (int) (numPieces / 50));
        this.numPieces = numPieces;
    }

    @Override
    public void play() {
        System.out.printf("You solved the puzzle of %d pieces!", this.numPieces);
        System.out.println();
    }
}

class Doll extends Toy {
    private String name;
    
    public Doll(double price, String name) {
        super(price, 4);
        this.name = name;
    }

    @Override
    public void play() {
        System.out.printf("You role played with %s", this.name);
        System.out.println();
    }
}