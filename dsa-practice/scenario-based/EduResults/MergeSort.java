import java.util.*;

public class MergeSort {

    public static List<Student> mergeSort(List<Student> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;

        List<Student> left = mergeSort(list.subList(0, mid));
        List<Student> right = mergeSort(list.subList(mid, list.size()));

        return merge(left, right);
    }

    private static List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).score >= right.get(j).score) { // stable
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));

        return result;
    }
}
