// import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) throws Exception {
        // TODO: Demonstrate Code Reuse
        Tuple<Boolean, Integer> boolIntTuple = new Tuple<>(false, 3);
        Tuple<String, String> stringTuple = new Tuple<>("a", "B");

        boolean bool = boolIntTuple.getFirst();
        int num = boolIntTuple.getSecond();
        String str = stringTuple.getFirst();

        // TODO: Demonstrate Type Checking
        Tuple<Integer, Integer> genericTuple = new Tuple<>(1, 1);
        int genericSum = genericTuple.getFirst() + genericTuple.getSecond();

        System.out.println(genericSum);
    }
    
    // TODO: Demonstrate Wildcards
    // ArrayList<Integer> intsList = new ArrayList<>();
    
    // for (int i = 1; i <= 10; i++) {
    //     intsList.add(i);
    // }

    // Generics are non-covariant!
    // System.out.println(getIntSum(intsList));

    // private static int getIntSum(ArrayList<Number> numList) {
        //     int intSum = 0;
        //     for (Number num : numList) {
    //         intSum += num.intValue();
    //     }

    //     return intSum;
    // }
}