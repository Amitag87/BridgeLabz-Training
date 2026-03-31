
import java.io.*;
public class Streams
{
	public static void main(String[] args) {
// 		System.out.println("Hello World");
    try{
        FileReader fr=new FileReader("input.txt");
        FileWriter fw=new FileWriter("output.txt");
        int ch;
        while((ch=fr.read())!=-1){
            fw.write(ch);
        }
        fr.close();
        fw.close();
        System.out.println("File Copied Successfully");
        
    }
        catch(IOException e){
            e.printStackTrace();
        }
	}
}
