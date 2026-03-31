import java.util.regex.*;
import java.util.*;

public class FindRepeatingWords {
    public static void main(String[] args) {
        String input = "This is is a repeated repeated word test.";
        String regex = "\\b(\\w+)\\s+\\1\\b";
        
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        
        Set<String> repeatingWords = new HashSet<>();
        
        while (matcher.find()) {
            repeatingWords.add(matcher.group(1).toLowerCase());
        }
        
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Repeating words: " + String.join(", ", repeatingWords));
    }
}