import java.util.Arrays;

// LeetCode 136: Single Number
public class SingleNumber {
    public static void main(String[] args) {
        int[][] testCases = {
            {2, 2, 1},
            {4, 1, 2, 1, 2},
            {1}
        };
        
        for (int[] nums : testCases) {
            int result = singleNumber(nums);
            System.out.println(Arrays.toString(nums) + " -> " + result);
        }
    }
    
    static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR operation
        }
        return result;
    }
}