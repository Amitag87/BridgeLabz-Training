
import java.util.*;


public class ReverseArrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }
}
