import java.io.*;

public class InputStreamReaderUserInput {
    public static void main(String[] args) {
        String fileName = "userinput.txt";
        
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(fileName)) {
            
            System.out.println("Enter text (type 'exit' to stop):");
            String input;
            
            while (!(input = br.readLine()).equals("exit")) {
                fw.write(input + "\n");
                fw.flush();
                System.out.println("Written to file. Enter more text:");
            }
            
            System.out.println("Input saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}