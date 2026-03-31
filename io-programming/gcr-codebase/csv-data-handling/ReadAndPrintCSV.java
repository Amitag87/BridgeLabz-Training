
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

 class ReadAndPrintCSV {
    public static void main(String[] args) {
        String filepath="data.csv";
        String line;
        try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
            line=br.readLine();
            while((line=br.readLine())!=null){
                String values[]=line.split(",");
                int id=Integer.parseInt(values[0]);
                String name=values[1];
                int age=Integer.parseInt(values[2]);
                System.out.println("Id: "+id+", Name: "+name+", Age: "+age);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
