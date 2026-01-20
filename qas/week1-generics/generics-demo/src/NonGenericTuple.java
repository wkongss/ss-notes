public class NonGenericTuple {
    private final Object item1;
    private final Object item2;

    // We pass in two generic objects
    public NonGenericTuple(Object item1, Object item2) throws NullPointerException {
        if (item1 == null) {
            throw new NullPointerException("item1 cannot be null");
        }

        if (item2 == null) {
            throw new NullPointerException("item2 cannot be null");
        }

        this.item1 = item1;
        this.item2 = item2;
    }

    // We can only return Objects without an explicit, unsafe cast
    public Object getFirst() {
        return this.item1;
    } 

    public Object getSecond() {
        return this.item2;
    }

    @Override
    public String toString() {
        return "Tuple(" + 
        this.item1.toString() + ", " + 
        this.item2.toString() + 
        ")";
    }
}
