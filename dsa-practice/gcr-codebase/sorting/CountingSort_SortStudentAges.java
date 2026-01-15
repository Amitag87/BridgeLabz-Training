public class CountingSort_SortStudentAges {
    public static void main(String[] args) {
        int[] studentAges = {15, 12, 18, 14, 16, 12, 15, 17, 13, 18, 14};
        System.out.println("Student Ages before Sorting:");
        for (int age : studentAges) {
            System.out.print(age + " ");
        }
        countingSort(studentAges);
        System.out.println("\nStudent Ages after Sorting:");
        for (int age : studentAges) {
            System.out.print(age + " ");
        }
    }

    static void countingSort(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) max = arr[i];
        }

        int[] count = new int[max + 1];
        for (int num : arr) {
            count[num]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
