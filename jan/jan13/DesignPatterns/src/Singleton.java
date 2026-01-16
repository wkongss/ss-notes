public class Singleton {
    // For when only want one instance of an object.
    // Design pattern can be used to ensure that every thread is using the same object.

    // If instance is instantiated as soon as possible: eager loading (faster, but no guarantee):
    // private static int Singleton instance = new Singleton();
    private static Singleton instance; // Create a singleton object that is used - do not allow external constructors
    private int count = 0;

    private Singleton() {

    }

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int getCount() {
        return this.count;
    }

    public static Singleton getInstance() {
        // If instance is loaded only when necessary: lazy loading -
        // if (Singleton.instance == null) {
        //     Singleton.instance = new Singleton();
        // }

        return Singleton.instance;
    }
}
