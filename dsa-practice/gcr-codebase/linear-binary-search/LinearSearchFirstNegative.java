public class LinearSearchFirstNegative {
    public static void main(String[] args) {
        int[] arr = {5, 3, -2, 8, -7, 1};
        int index = findFirstNegative(arr);
        
        if (index != -1) {
            System.out.println("First negative number " + arr[index] + " found at index: " + index);
        } else {
            System.out.println("No negative number found");
        }
    }
    
    static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}