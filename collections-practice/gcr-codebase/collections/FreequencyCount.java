
import java.util.*;

public class FreequencyCount {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String,Integer> freqMap = new HashMap<>();
        for(String item:list){
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }
        System.out.println(freqMap);
    }
}
