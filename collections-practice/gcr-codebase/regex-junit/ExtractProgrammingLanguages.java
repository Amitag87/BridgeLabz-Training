import java.util.regex.*;

public class ExtractProgrammingLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        String regex = "\\b(Java|Python|JavaScript|Go|C\\+\\+|C#|Ruby|PHP|Swift|Kotlin)\\b";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Programming languages found:");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}