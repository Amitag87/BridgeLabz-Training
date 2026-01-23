import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String filename = "largelog.txt";
        
        // Create a test log file
        createTestLogFile(filename);
        
        // Read file line by line and find error lines
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;
            int errorCount = 0;
            
            System.out.println("Lines containing 'error':");
            
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.toLowerCase().contains("error")) {
                    System.out.println("Line " + lineNumber + ": " + line);
                    errorCount++;
                }
            }
            
            System.out.println("\nTotal lines processed: " + lineNumber);
            System.out.println("Error lines found: " + errorCount);
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    static void createTestLogFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            String[] logEntries = {
                "INFO: Application started successfully",
                "DEBUG: Loading configuration files",
                "ERROR: Database connection failed",
                "WARN: Memory usage is high",
                "INFO: User login successful",
                "ERROR: File not found exception occurred",
                "DEBUG: Processing user request",
                "INFO: Data saved successfully",
                "ERROR: Network timeout occurred",
                "INFO: Application shutdown complete"
            };
            
            // Write multiple copies to make it larger
            for (int i = 0; i < 1000; i++) {
                for (String entry : logEntries) {
                    writer.write(entry);
                    writer.newLine();
                }
            }
            
            System.out.println("Test log file created: " + filename);
            
        } catch (IOException e) {
            System.out.println("Error creating test file: " + e.getMessage());
        }
    }
}