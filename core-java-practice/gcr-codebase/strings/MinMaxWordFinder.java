package strings;

public class MinMaxWordFinder {

    public static int[] findMinMax(String[][] table) {
        int min = Integer.parseInt(table[0][1]);
        int max = min;

        for (String[] row : table) {
            int length = Integer.parseInt(row[1]);
            min = Math.min(min, length);
            max = Math.max(max, length);
        }
        return new int[]{min, max};
    }
}
