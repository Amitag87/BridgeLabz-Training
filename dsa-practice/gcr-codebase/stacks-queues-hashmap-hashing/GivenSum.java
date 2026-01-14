import java.util.*;

public class GivenSum {
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};

        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        map.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    System.out.println("Subarray found from index "
                            + (startIndex + 1) + " to " + i);
                } 
            }

            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
    }
}
