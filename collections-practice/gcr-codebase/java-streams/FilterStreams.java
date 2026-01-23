import java.io.*;

public class FilterStreams {
    public static void main(String[] args) {
        String sourceFile = "uppercase.txt";
        String destFile = "lowercase.txt";
        
        // Create source file with uppercase content
        try (FileWriter writer = new FileWriter(sourceFile)) {
            writer.write("HELLO WORLD!\nTHIS IS A TEST FILE.\nJAVA PROGRAMMING IS AWESOME!");
            System.out.println("Source file created with uppercase content");
        } catch (IOException e) {
            System.out.println("Error creating source file: " + e.getMessage());
        }
        
        // Convert uppercase to lowercase
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            
            System.out.println("File converted from uppercase to lowercase: " + destFile);
            
        } catch (IOException e) {
            System.out.println("Error during conversion: " + e.getMessage());
        }
        
        // Display both files
        System.out.println("\nOriginal file content:");
        displayFile(sourceFile);
        
        System.out.println("\nConverted file content:");
        displayFile(destFile);
    }
    
    static void displayFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}