import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) throws Exception {
        // TODO: Demonstrate non-generic deficiencies
        NonGenericTuple objectTuple = new NonGenericTuple(1, 2);
        int sum = objectTuple.getFirst() + objectTuple.getSecond();

        System.out.println(sum);

        // TODO: Demonstrate Type Checking
        String s1 = "1", s2 = "2";
        Tuple<Integer, Integer> wrongTuple = new Tuple<>(s1, s2);
        String concat = wrongTuple.getFirst() + wrongTuple.getSecond();

        System.out.println(concat);

        // TODO: Demonstrate Wildcards
        ArrayList<Integer> intsList = new ArrayList<>();
        
        for (int i = 1; i <= 100; i++) {
            intsList.add(i);
        }

        // Generics are non-covariant!
        System.out.println(getIntSum(intsList));

    }

    private static int getIntSum(ArrayList<Number> numList) {
        int intSum = 0;
        for (Number num : numList) {
            intSum += num.intValue();
        }

        return intSum;
    }
}