import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String filename = "textfile.txt";
        
        // Create test file
        createTestFile(filename);
        
        // Count words
        Map<String, Integer> wordCount = countWords(filename);
        
        // Display results
        System.out.println("Total unique words: " + wordCount.size());
        System.out.println("\nTop 5 most frequent words:");
        
        wordCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
    
    static void createTestFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            String content = "Java is a programming language. " +
                           "Java is platform independent. " +
                           "Programming in Java is fun. " +
                           "Java programming language is powerful. " +
                           "Learning Java programming is essential for developers. " +
                           "Java developers are in high demand. " +
                           "Object oriented programming in Java is important.";
            writer.write(content);
            System.out.println("Test file created: " + filename);
        } catch (IOException e) {
            System.out.println("Error creating test file: " + e.getMessage());
        }
    }
    
    static Map<String, Integer> countWords(String filename) {
        Map<String, Integer> wordCount = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                // Remove punctuation and convert to lowercase
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        return wordCount;
    }
}