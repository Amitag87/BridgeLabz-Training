import java.io.*;

public class ByteArrayImageConverter {
    public static void main(String[] args) {
        String sourceImage = "source.jpg";
        String destImage = "copy.jpg";
        
        // Create a dummy image file for testing
        createDummyImage(sourceImage);
        
        try {
            // Read image into byte array
            byte[] imageBytes = imageToByteArray(sourceImage);
            System.out.println("Image converted to byte array. Size: " + imageBytes.length + " bytes");
            
            // Write byte array back to image file
            byteArrayToImage(imageBytes, destImage);
            System.out.println("Byte array converted back to image: " + destImage);
            
            // Verify files are identical
            if (areFilesIdentical(sourceImage, destImage)) {
                System.out.println("Files are identical - conversion successful!");
            } else {
                System.out.println("Files are different - conversion failed!");
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    static void createDummyImage(String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            // Create a simple dummy file
            byte[] dummyData = "DUMMY_IMAGE_DATA_FOR_TESTING".getBytes();
            fos.write(dummyData);
        } catch (IOException e) {
            System.out.println("Error creating dummy image: " + e.getMessage());
        }
    }
    
    static byte[] imageToByteArray(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            
            return baos.toByteArray();
        }
    }
    
    static void byteArrayToImage(byte[] imageBytes, String filename) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(filename)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
    
    static boolean areFilesIdentical(String file1, String file2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {
            
            int byte1, byte2;
            while ((byte1 = fis1.read()) != -1 && (byte2 = fis2.read()) != -1) {
                if (byte1 != byte2) return false;
            }
            
            return fis1.read() == -1 && fis2.read() == -1;
        }
    }
}