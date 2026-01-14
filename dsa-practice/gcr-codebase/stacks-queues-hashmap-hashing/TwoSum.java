import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(arr, target);
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);
        System.out.println("Indices: " + Arrays.toString(result));
        
        int[] arr2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(arr2, target2);
        System.out.println("\nArray: " + Arrays.toString(arr2));
        System.out.println("Target: " + target2);
        System.out.println("Indices: " + Arrays.toString(result2));
    }
    
    static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }
}
