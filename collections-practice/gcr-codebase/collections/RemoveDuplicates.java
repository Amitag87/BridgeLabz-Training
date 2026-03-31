public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        System.out.println("Original array:");
        printArray(arr);
        int[] result = removeDuplicates(arr);
        printArray(result);
    }
    public static int[] removeDuplicates(int[] arr) {
        if (arr.length == 0) return new int[0];
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        int[] result = new int[j + 1];
        System.arraycopy(arr, 0, result, 0, j + 1);
        return result;
    }
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
