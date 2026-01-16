import java.util.ArrayList;
import java.util.LinkedList;

public class ListsDriver {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();

        ints.add(5);
        ints.add(-5);
        ints.add(300);
        
        System.out.println(ints);
        ints.remove(Integer.valueOf(5));
        System.out.println(ints);

        // Linked Lists
        // Nodes have prev, next pointers and a data value.
        // Fast insertions to front O(1).
        // Slow random access - O(n)
        LinkedList<Integer> intsLinked = new LinkedList<>();

        intsLinked.add(5);
        intsLinked.add(-5);
        intsLinked.add(300);

        System.out.println(intsLinked);
        intsLinked.remove(Integer.valueOf(5));
        System.out.println(intsLinked);
    }
}
