import java.io.*;

public class BufferedStreamsCopy {
    public static void main(String[] args) {
        String sourceFile = "largefile.txt";
        String destFile1 = "copy_unbuffered.txt";
        String destFile2 = "copy_buffered.txt";
        
        // Create a test file
        createTestFile(sourceFile, 1000000); // 1MB file
        
        // Unbuffered copy
        long startTime = System.nanoTime();
        copyUnbuffered(sourceFile, destFile1);
        long unbufferedTime = System.nanoTime() - startTime;
        
        // Buffered copy
        startTime = System.nanoTime();
        copyBuffered(sourceFile, destFile2);
        long bufferedTime = System.nanoTime() - startTime;
        
        System.out.println("Unbuffered copy time: " + unbufferedTime / 1000000 + " ms");
        System.out.println("Buffered copy time: " + bufferedTime / 1000000 + " ms");
        System.out.println("Performance improvement: " + (unbufferedTime / (double) bufferedTime) + "x faster");
    }
    
    static void createTestFile(String filename, int size) {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            for (int i = 0; i < size; i++) {
                fos.write("A".getBytes());
            }
        } catch (IOException e) {
            System.out.println("Error creating test file: " + e.getMessage());
        }
    }
    
    static void copyUnbuffered(String source, String dest) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        } catch (IOException e) {
            System.out.println("Error in unbuffered copy: " + e.getMessage());
        }
    }
    
    static void copyBuffered(String source, String dest) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error in buffered copy: " + e.getMessage());
        }
    }
}