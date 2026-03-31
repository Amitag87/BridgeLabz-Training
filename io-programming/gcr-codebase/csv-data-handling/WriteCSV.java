import java.io.*;

public class WriteCSV{
    public static void main(String[] args) {
        String filePath="data.csv";
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("data.csv"))){
            bw.append("Id,Name,Age");
            bw.newLine();
            bw.append("02,Himanshi,20");
            bw.newLine();
            bw.append("01,Amit,21");
            System.out.println("CSV file written successfully");

        }
            
         catch (IOException e) {
            e.printStackTrace();
        }
    }
}