import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        
        return new int[]{};
    }
    
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Input: " + Arrays.toString(nums1) + ", target: " + target1);
        System.out.println("Output: " + Arrays.toString(solution.twoSum(nums1, target1)));
        
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Input: " + Arrays.toString(nums2) + ", target: " + target2);
        System.out.println("Output: " + Arrays.toString(solution.twoSum(nums2, target2)));
    }
}