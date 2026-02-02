import java.io.*;
import java.util.Scanner;
public class SearchEmployees {
    public static void main(String[] args) {
        String filePath="data.csv";
        Scanner sc=new Scanner(System.in);
        String searchName=sc.nextLine();
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            br.readLine();
            String line;
            boolean found=false;
            while((line=br.readLine())!=null){
                String[] data=line.split(",");
                String name=data[1].trim();
                if(name.equalsIgnoreCase(searchName)){
                    System.out.println("Id: "+data[0]+", Name: "+data[1]+", Age: "+data[2]);
                    found=true;
                    break;
                }
            }
            if(!found){
                System.out.println("Employee not found.");
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
