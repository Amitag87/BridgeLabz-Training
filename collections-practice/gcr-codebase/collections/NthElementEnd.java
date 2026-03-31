public class NthElementEnd {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 2; 
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        System.out.println("The " + n + "th element from the end is: " + getNthElementFromEnd(arr, n));
    }

    public static int getNthElementFromEnd(int[] arr, int n) {
        if (n <= 0 || n > arr.length) {
            throw new IllegalArgumentException("Invalid position");
        }
        return arr[arr.length - n];
    }
}