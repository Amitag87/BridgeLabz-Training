import java.io.*;
public class FilterRecord {
    public static void main(String[] args) {
        String filepath="data.csv";
        String line;
        try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
            line=br.readLine();
            System.out.println("Records with Age > 20:");
            while((line=br.readLine())!=null){
                String values[]=line.split(",");
                int age=Integer.parseInt(values[2]);
                if(age>80){
                    int id=Integer.parseInt(values[0]);
                    String name=values[1];
                    System.out.println("Id: "+id+", Name: "+name+", Age: "+age);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
