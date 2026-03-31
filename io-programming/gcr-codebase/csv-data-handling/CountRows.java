import java.io.*;
public class CountRows {
    public static void main(String[] args) {
        String filepath="data.csv";
        int count=0;
        String data;
        try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
            data=br.readLine();
            while((data=br.readLine())!=null){
                if(!data.trim().isEmpty())count++;
            }System.out.println("Number of data rows: "+count);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
