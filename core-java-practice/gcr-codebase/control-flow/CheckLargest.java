package BridgeLab;
import java.util.*;
public class CheckLargest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		int num3=sc.nextInt();
		if(num1>num2 && num2>num3) {
			System.out.println("Is the first number the largest?YES");
			System.out.println("Is the second number the largest?NO");
			System.out.println("Is the third number the largest?NO");
		}
		else if(num2>num1 && num2>num3) {
			System.out.println("Is the first number the largest?NO");
			System.out.println("Is the second number the largest?YES");
			System.out.println("Is the third number the largest?NO");
		}
		else {
			System.out.println("Is the first number the largest?NO");
			System.out.println("Is the second number the largest?NO");
			System.out.println("Is the third number the largest?YES");
		}
	}
}
