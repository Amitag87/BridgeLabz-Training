package BridgeLab;
import java.util.*;
public class StudentFeeDiscount {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int studFee=sc.nextInt();
	int disP=sc.nextInt();
	int dis=(disP*studFee)/100;
	int discountedAmt=studFee-dis;
	System.out.print("The discounted amount is INR "+dis+" and the amount after discount in fees is: "+discountedAmt);
}
}
