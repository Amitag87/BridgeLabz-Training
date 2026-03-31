import java.util.HashSet;

public class StringBuilderRemoveDuplicates {
    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);
        System.out.println("Original: " + input);
        System.out.println("Without duplicates: " + result);
    }
    
    static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        
        for (char c : str.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        return sb.toString();
    }
}