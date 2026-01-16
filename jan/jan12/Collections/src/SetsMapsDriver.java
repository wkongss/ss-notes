import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SetsMapsDriver {
    public static void main(String[] args) {
        // HashMap maps a unique key to a value in a key-value pair.
        // USes hashing (hashCode) under the hood.
        // Generally leads to fast insertions, lookups, deletions - O(1) expected time.
        // Collisions are resolved via bucketing with linkedlists.

        HashMap<Integer, String> romanNums = new HashMap<>();

        romanNums.put(1, "I");
        romanNums.put(4, "IV");
        romanNums.put(10, "X");

        for (Integer key : romanNums.keySet()) {
            System.out.println(key);
        }

        for (String value : romanNums.values()) {
            System.out.println(value);
        }

        // HashSet
        // Collection of unique elements
        // Uses hashing hashCode() for indexing and equals() for comparison
        // Fast insertions, deletions, lookup (in set or not) - O(1) expected
        
        HashSet<String> numerals = new HashSet<>();

        numerals.add("XII");
        numerals.add("XV");
        numerals.add("XX");

        for (String numeral : numerals) {
            System.out.println(numeral);
        }

        System.out.println(numerals.contains("XX"));
        System.out.println(numerals.contains("XXI"));

        // All Standard collections implement the Iterable interface that allows
        // for for each loops. We can also access the iterator() directly by calling
        // the iterator() method. Note that many collections don't have guarantees
        // on the order in which elements are iterated.

        Iterator<String> iter = numerals.iterator();

        while (iter.hasNext()) {
            String _ = iter.next();
            // Do stuff here
        }
    }
}
