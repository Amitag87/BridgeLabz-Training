package BridgeLab;
import java.util.*;
public class QuantityBrought {
	public static void main(String[] args) {
		
	
	Scanner sc=new Scanner(System.in);
	int unitPrice=sc.nextInt();
	int quantity=sc.nextInt();
	System.out.print("The total purchase price is INR "+unitPrice+" if the quantity "+ quantity+" and unit price is INR "+ unitPrice*quantity);

	}
}
