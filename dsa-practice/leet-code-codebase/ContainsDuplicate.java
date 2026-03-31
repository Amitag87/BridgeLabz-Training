import java.util.HashSet;
import java.util.Arrays;

// LeetCode 217: Contains Duplicate
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 3, 1},
            {1, 2, 3, 4},
            {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}
        };
        
        for (int[] nums : testCases) {
            boolean result = containsDuplicate(nums);
            System.out.println(Arrays.toString(nums) + " -> " + result);
        }
    }
    
    static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}