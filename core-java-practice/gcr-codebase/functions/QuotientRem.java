package functions;

import java.util.Scanner;

public class QuotientRem {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		System.out.println(quo(num1,num2));

		System.out.println(rem(num1,num2));
	}
	public static int quo(int num1,int num2) {
		return num1/num2;
	}
	public static int rem(int num1,int num2) {
		return num1%num2;
	}
}
