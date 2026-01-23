import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";
        
        // Create source file for testing
        try (FileOutputStream fos = new FileOutputStream(sourceFile)) {
            String content = "Hello World!\nThis is a test file.\nJava File Handling Example.";
            fos.write(content.getBytes());
            System.out.println("Source file created");
        } catch (IOException e) {
            System.out.println("Error creating source file: " + e.getMessage());
        }
        
        // Read from source and write to destination
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            
            System.out.println("File copied successfully from " + sourceFile + " to " + destFile);
            
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.out.println("Error during file operation: " + e.getMessage());
        }
    }
}