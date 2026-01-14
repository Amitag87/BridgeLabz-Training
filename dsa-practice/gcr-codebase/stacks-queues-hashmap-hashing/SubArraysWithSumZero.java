import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class SubArraysWithSumZero {
    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6};
        System.out.println("Array: " + Arrays.toString(arr));
        findAllSubarrays(arr);
        
        int[] arr2 = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        System.out.println("\nArray: " + Arrays.toString(arr2));
        findAllSubarrays(arr2);
    }
    
    static void findAllSubarrays(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(-1)));
        int sum = 0, count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    System.out.println("Subarray [" + (start + 1) + ", " + i + "]");
                    count++;
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        System.out.println("Total subarrays with sum zero: " + count);
    }
}
