import java.io.*;

public class ChallengeStringIOComparison {
    public static void main(String[] args) {
        // Test StringBuilder vs StringBuffer
        testStringConcatenation();
        
        // Test FileReader vs InputStreamReader
        testFileReading();
    }
    
    static void testStringConcatenation() {
        int iterations = 100000;
        
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("hello");
        }
        long sbTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append("hello");
        }
        long sbfTime = System.nanoTime() - startTime;
        
        System.out.println("String Concatenation Performance:");
        System.out.println("StringBuilder: " + sbTime + " ns");
        System.out.println("StringBuffer: " + sbfTime + " ns");
        System.out.println("Performance ratio: " + (sbfTime / (double) sbTime));
    }
    
    static void testFileReading() {
        String fileName = "largefile.txt";
        
        // Create test file
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < 10000; i++) {
                writer.write("This is line " + i + " with some sample text for testing file reading performance.\n");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
            return;
        }
        
        // Test FileReader
        long startTime = System.nanoTime();
        int wordCount1 = countWordsFileReader(fileName);
        long frTime = System.nanoTime() - startTime;
        
        // Test InputStreamReader
        startTime = System.nanoTime();
        int wordCount2 = countWordsInputStreamReader(fileName);
        long isrTime = System.nanoTime() - startTime;
        
        System.out.println("\nFile Reading Performance:");
        System.out.println("FileReader - Words: " + wordCount1 + ", Time: " + frTime + " ns");
        System.out.println("InputStreamReader - Words: " + wordCount2 + ", Time: " + isrTime + " ns");
        System.out.println("Performance ratio: " + (frTime / (double) isrTime));
    }
    
    static int countWordsFileReader(String fileName) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return wordCount;
    }
    
    static int countWordsInputStreamReader(String fileName) {
        int wordCount = 0;
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return wordCount;
    }
}