import java.util.Arrays;

public class nextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // 1. Find breakpoint
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 2. Find next greater element and swap
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 3. Reverse the suffix
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    // ✅ Main method
    public static void main(String[] args) {
        nextPermutation obj = new nextPermutation();

        int[] nums = {3, 2, 1};  // test input
        System.out.println("Before: " + Arrays.toString(nums));

        obj.nextPermutation(nums);

        System.out.println("After:  " + Arrays.toString(nums));
    }
}
