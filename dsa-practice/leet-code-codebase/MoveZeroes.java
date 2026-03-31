import java.util.Arrays;

// LeetCode 283: Move Zeroes
public class MoveZeroes {
    public static void main(String[] args) {
        int[][] testCases = {
            {0, 1, 0, 3, 12},
            {0},
            {1, 0, 2, 0, 3, 0, 4}
        };
        
        for (int[] nums : testCases) {
            System.out.println("Before: " + Arrays.toString(nums));
            moveZeroes(nums);
            System.out.println("After:  " + Arrays.toString(nums));
            System.out.println();
        }
    }
    
    static void moveZeroes(int[] nums) {
        int writeIndex = 0;
        
        for (int readIndex = 0; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != 0) {
                nums[writeIndex++] = nums[readIndex];
            }
        }
        
        while (writeIndex < nums.length) {
            nums[writeIndex++] = 0;
        }
    }
}