package functions;

import java.util.Scanner;

public class SumOfNumberRec {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int sum=sum(n);
		int sumForm=n*(n+1)/2;
		if(sum==sumForm) {
			System.out.println("equaaal");
		}
		else {
			System.out.println("Not equal");
		}
	}
	public static int sum(int n) {
		if(n==0) {
			return 0;
		}
		return n+ sum(n-1);
	}
}
