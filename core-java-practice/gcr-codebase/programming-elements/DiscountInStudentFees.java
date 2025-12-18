package BridgeLab;
import java.util.*;
public class DiscountInStudentFees{
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int studFee=12500;
	int disP=4;
	int dis=(disP*studFee)/100;
	int discountedAmt=studFee-dis;
	System.out.print("The discounted amount is INR "+dis+" and the amount after discount in fees is: "+discountedAmt);
}
}
