import java.util.regex.*;

public class ValidateSSN {
    public static void main(String[] args) {
        String text = "My SSN is 123-45-6789.";
        String[] testSSNs = {"123-45-6789", "123456789", "12-345-6789", "123-45-67890"};
        
        // Extract SSN from text
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("SSN found in text:");
        while (matcher.find()) {
            System.out.println("✅ \"" + matcher.group() + "\" is valid");
        }
        
        // Test various SSN formats
        System.out.println("\\nTesting SSN formats:");
        for (String ssn : testSSNs) {
            if (ssn.matches(regex)) {
                System.out.println("✅ \"" + ssn + "\" is valid");
            } else {
                System.out.println("❌ \"" + ssn + "\" is invalid");
            }
        }
    }
}