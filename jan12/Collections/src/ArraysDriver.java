public class ArraysDriver {
    /***
     * 
     * @param arr a sorted integer array
     * @param target the target integer to search for
     * @return an index that contains the target. If none exists, returns -1
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (int)((left + right) / 2);
            int value = arr[mid];

            if (value < target) {
                left = mid + 1;
            }
            else if (value > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    } 

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 7, 8, 9, 10};
        int[] nums2 = new int[3];
    
        System.out.println(nums1[4]);
        nums1[4] = 6;
        System.out.println(nums1[4]);
        
        System.out.println(binarySearch(nums1, 20));

        Vehicle[] vehicles = new Vehicle[2];

        vehicles[0] = new Car();
        vehicles[1] = new Segway();

        // For loop - loops through a certain start and end condition for
        // an index i

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }

        // Foreach loop - loops through all elements in an iterable once - no access
        // to an ordered index

        for (int num : nums1) {
            System.out.println(num);
        }

        // While loops and do while loops will loop until their condition is false.
    }
}
