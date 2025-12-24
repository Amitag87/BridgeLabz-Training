package functions;

import java.util.Scanner;

public class CheckNum {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		checkNum(n);
	}
	public static void checkNum(int n) {
		if(n>0) {
			System.out.println("num is +ve");
		}
		else if(n<0) {
			System.out.println("num  is -ve");
		}
		else {
			System.out.println("num is 0");
		}
	}
}
