import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class ValidateCSVData {
    
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$");
    private static final Pattern PHONE_PATTERN = 
        Pattern.compile("^\\d{10}$");
    
    static class ValidationResult {
        boolean isValid;
        List<String> errors;
        
        public ValidationResult() {
            this.isValid = true;
            this.errors = new ArrayList<>();
        }
        
        public void addError(String error) {
            this.isValid = false;
            this.errors.add(error);
        }
    }
    
    public static void main(String[] args) {
        createSampleCSVWithInvalidData();
        validateCSVData();
    }
    
    private static void createSampleCSVWithInvalidData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("employees_validation.csv"))) {
            writer.println("ID,Name,Email,Phone,Department");
            writer.println("1,John Doe,john.doe@company.com,1234567890,Engineering");
            writer.println("2,Jane Smith,invalid-email,9876543210,Marketing");
            writer.println("3,Mike Johnson,mike@company.com,123456789,Engineering"); // Invalid phone
            writer.println("4,Sarah Wilson,sarah.wilson@company.com,555-123-4567,HR"); // Invalid phone format
            writer.println("5,David Brown,david@,9876543210,Finance"); // Invalid email
            writer.println("6,Lisa Davis,lisa.davis@company.com,1234567890,Engineering");
            writer.println("7,Tom Miller,tom.miller@company.com,98765432101,Marketing"); // Too many digits
            writer.println("8,Amy Taylor,amy.taylor@company.com,9876543210,Finance");
        } catch (IOException e) {
            System.err.println("Error creating sample CSV: " + e.getMessage());
        }
    }
    
    private static void validateCSVData() {
        System.out.println("Validating CSV Data...\n");
        
        try (BufferedReader reader = new BufferedReader(new FileReader("employees_validation.csv"))) {
            String line = reader.readLine(); // Skip header
            int lineNumber = 1;
            
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] parts = line.split(",");
                
                if (parts.length >= 5) {
                    ValidationResult result = validateRow(parts);
                    
                    if (!result.isValid) {
                        System.out.println("Invalid row at line " + lineNumber + ":");
                        System.out.println("Data: " + line);
                        System.out.println("Errors:");
                        for (String error : result.errors) {
                            System.out.println("  - " + error);
                        }
                        System.out.println();
                    } else {
                        System.out.println("Valid row at line " + lineNumber + ": " + parts[1]);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
    
    private static ValidationResult validateRow(String[] parts) {
        ValidationResult result = new ValidationResult();
        
        // Validate email (index 2)
        String email = parts[2].trim();
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            result.addError("Invalid email format: " + email);
        }
        
        // Validate phone (index 3)
        String phone = parts[3].trim();
        if (!PHONE_PATTERN.matcher(phone).matches()) {
            result.addError("Invalid phone number (must be exactly 10 digits): " + phone);
        }
        
        return result;
    }
}