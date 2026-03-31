public class TwoSetsEqual {
    public static void main(String[] args) {
        int[] set1 = {1, 2, 3, 4, 5};
        int[] set2 = {5, 4, 3, 2, 1};
        System.out.println("Are the two sets equal? " + areEqual(set1, set2));
    }

    public static boolean areEqual(int[] set1, int[] set2) {
        if (set1.length != set2.length) {
            return false;
        }
        for (int i = 0; i < set1.length; i++) {
            if (set1[i] != set2[i]) {
                return false;
            }
        }
        return true;
    }
}