
import java.util.regex.*;

public class AllCapitalizedWords {
    public static void main(String[] args) {
        String text="Radhe Radhe everyone.This side Hodophile Express";
        String regex="\\b[A-Z][a-z]*\\b";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
