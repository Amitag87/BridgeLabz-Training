package extra;
import java.util.LinkedHashSet;

public class RemoveDuplicates {
    
    public static String removeDuplicates(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : set) {
            result.append(c);
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);
        
        System.out.println("Original: " + input);
        System.out.println("After removing duplicates: " + result);
    }
}