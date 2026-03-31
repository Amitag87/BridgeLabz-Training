import java.io.*;
public class ReadFile {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("data.txt");
            int ch;
            while((ch=fis.read())!=-1){
                System.out.println((char)ch);
            }
            fis.close();
        } catch (IOException e) {
            System.out.println("file not found");
        }
    }
}
