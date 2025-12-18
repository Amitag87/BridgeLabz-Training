package BridgeLab;
import java.util.*;
public class HeightConversion {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int height=sc.nextInt();
		double hInInches=height*(1/2.54);
		double hInFeet=hInInches/12;
		System.out.println("Your height in cm is "+height+"while in feet is "+ hInInches+" and inches "+ hInFeet);
	}

}
