import java.io.*;

public class PipedStreams {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            
            // Writer thread
            Thread writerThread = new Thread(() -> {
                try (DataOutputStream dos = new DataOutputStream(pos)) {
                    for (int i = 1; i <= 5; i++) {
                        dos.writeUTF("Message " + i);
                        System.out.println("Sent: Message " + i);
                        Thread.sleep(1000);
                    }
                } catch (IOException | InterruptedException e) {
                    System.out.println("Writer error: " + e.getMessage());
                }
            });
            
            // Reader thread
            Thread readerThread = new Thread(() -> {
                try (DataInputStream dis = new DataInputStream(pis)) {
                    String message;
                    while ((message = dis.readUTF()) != null) {
                        System.out.println("Received: " + message);
                    }
                } catch (IOException e) {
                    System.out.println("Reader finished or error: " + e.getMessage());
                }
            });
            
            writerThread.start();
            readerThread.start();
            
            writerThread.join();
            readerThread.join();
            
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}