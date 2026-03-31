import java.io.*;

public class FileReadingAnalysis {
    public static void main(String[] args) {
        String[] fileSizes = {"small.txt", "medium.txt", "large.txt"};
        int[] sizes = {1000, 10000, 50000}; // Number of lines
        
        // Create test files
        for (int i = 0; i < fileSizes.length; i++) {
            createTestFile(fileSizes[i], sizes[i]);
        }
        
        for (int i = 0; i < fileSizes.length; i++) {
            System.out.println("\nFile: " + fileSizes[i] + " (" + sizes[i] + " lines)");
            
            // FileReader test
            long start = System.nanoTime();
            int lines1 = readWithFileReader(fileSizes[i]);
            long frTime = System.nanoTime() - start;
            
            // InputStreamReader test
            start = System.nanoTime();
            int lines2 = readWithInputStreamReader(fileSizes[i]);
            long isrTime = System.nanoTime() - start;
            
            System.out.println("FileReader:        " + frTime / 1000000 + " ms");
            System.out.println("InputStreamReader: " + isrTime / 1000000 + " ms");
            System.out.println("Performance Ratio: " + (frTime / (double) isrTime) + "x");
        }
    }
    
    static void createTestFile(String filename, int lines) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < lines; i++) {
                writer.write("This is line " + i + " with some sample text for testing file reading performance.\\n");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }
    
    static int readWithFileReader(String filename) {
        int lineCount = 0;
        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)) {
            while (br.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Error reading with FileReader: " + e.getMessage());
        }
        return lineCount;
    }
    
    static int readWithInputStreamReader(String filename) {
        int lineCount = 0;
        try (FileInputStream fis = new FileInputStream(filename);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            while (br.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Error reading with InputStreamReader: " + e.getMessage());
        }
        return lineCount;
    }
}