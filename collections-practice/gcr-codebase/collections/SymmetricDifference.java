public class SymmetricDifference {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};

        System.out.println("Symmetric difference of the arrays:");
        printArray(symmetricDifference(arr1, arr2));
    }

    public static int[] symmetricDifference(int[] arr1, int[] arr2) {
        java.util.Set<Integer> set1 = new java.util.HashSet<>();
        java.util.Set<Integer> set2 = new java.util.HashSet<>();
        java.util.Set<Integer> result = new java.util.HashSet<>();

        for (int num : arr1) {
            set1.add(num);
        }
        for (int num : arr2) {
            set2.add(num);
        }

        for (int num : set1) {
            if (!set2.contains(num)) {
                result.add(num);
            }
        }
        for (int num : set2) {
            if (!set1.contains(num)) {
                result.add(num);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}