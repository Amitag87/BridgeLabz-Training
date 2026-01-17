import java.io.*;

public class FileReaderLineByLine {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        
        // Create sample file first
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Line 1: Hello World\n");
            writer.write("Line 2: Java Programming\n");
            writer.write("Line 3: File Reading Example\n");
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
        
        // Read file line by line
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}