public class InsertionSort_SortEmployeeIds {
    public static void main(String[] args) {
        int employeeIds[] = {105, 102, 108, 101, 107};
        int n = employeeIds.length;
        System.out.println("Employee IDs before Sorting: ");
        for (int id : employeeIds) {
            System.out.println(id);
        }
        System.out.println("Employee IDs after Sorting: ");
        insertionSort(employeeIds, n);
        for (int id : employeeIds) {
            System.out.println(id);
        }
    }

    public static void insertionSort(int employeeIds[], int n) {
        for (int i = 1; i < n; i++) {
            int key = employeeIds[i];
            int j = i - 1;

            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j = j - 1;
            }
            employeeIds[j + 1] = key;
        }
    }
}