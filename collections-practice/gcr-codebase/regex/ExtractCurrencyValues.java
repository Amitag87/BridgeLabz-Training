import java.util.regex.*;

public class ExtractCurrencyValues {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        String regex = "\\$?\\d+\\.\\d{2}";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Currency values found:");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}