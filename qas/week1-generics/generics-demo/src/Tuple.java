//                 v--v--- Type Parameters T and S
public class Tuple<T, S> {
    // We can define instance fields with generic types T, S
    private final T item1;
    private final S item2;

    // We can define methods with instance types T, S as type parameters
    public Tuple(T item1, S item2) throws NullPointerException {
        if (item1 == null) {
            throw new NullPointerException("item1 cannot be null");
        }

        if (item2 == null) {
            throw new NullPointerException("item2 cannot be null");
        }

        this.item1 = item1;
        this.item2 = item2;
    }

    // We can have return values of types T, S
    public T getFirst() {
        return this.item1;
    } 

    public S getSecond() {
        return this.item2;
    }

    // Type parameters defined in method definition
    public static <U, V> Tuple<V, U> getReversedTuple(Tuple<U, V> tuple) {
        V first = tuple.getSecond();
        U second = tuple.getFirst();

        return new Tuple<V, U>(first, second);
    }

    @Override
    public String toString() {
        return "Tuple(" + 
        this.item1.toString() + ", " + 
        this.item2.toString() + 
        ")";
    }
}