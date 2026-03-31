import java.io.*;

public class FileReaderWordCount {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        String targetWord = "Java";
        
        // Create sample file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Java is a programming language. Java is popular. Learn Java programming.\n");
            writer.write("Java developers are in demand. Java applications are everywhere.\n");
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
        
        int count = countWordOccurrences(fileName, targetWord);
        System.out.println("Word '" + targetWord + "' appears " + count + " times in the file.");
    }
    
    static int countWordOccurrences(String fileName, String targetWord) {
        int count = 0;
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.replaceAll("[^a-zA-Z]", "").equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return count;
    }
}