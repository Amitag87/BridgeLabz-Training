public class SelectionSort_SortExamScores {
    public static void main(String[] args) {
        int[] examScores = {78, 92, 65, 88, 71, 95, 82};
        System.out.println("Exam Scores before Sorting:");
        for (int score : examScores) {
            System.out.print(score + " ");
        }
        selectionSort(examScores);
        System.out.println("\nExam Scores after Sorting:");
        for (int score : examScores) {
            System.out.print(score + " ");
        }
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
