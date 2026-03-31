import java.util.regex.*;

public class ExtractLinks {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        String regex = "https?://[\\w.-]+";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Extracted links:");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}