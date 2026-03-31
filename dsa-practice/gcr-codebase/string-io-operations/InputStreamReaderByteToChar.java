import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputStreamReaderByteToChar {
    public static void main(String[] args) {
        String fileName = "utf8sample.txt";
        
        // Create sample UTF-8 file
        try (FileOutputStream fos = new FileOutputStream(fileName);
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
            osw.write("Hello World in UTF-8\n");
            osw.write("Special characters: àáâãäå\n");
            osw.write("Numbers: 12345\n");
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
        
        // Read using InputStreamReader
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}