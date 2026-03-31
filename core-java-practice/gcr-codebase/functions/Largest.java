package functions;

import java.util.Scanner;

public class Largest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		int n3=sc.nextInt();
		largest(n1,n2,n3);
		smallest(n1,n2,n3);
	}
	public static int largest(int n1,int n2,int n3) {
		if(n1>n2 && n1>n3) {
			System.out.println("n1 is the greatest");
			return 0;
		}
		else if(n1<n2 && n2>n3) {
			System.out.println("n2 is the greatest");
			return 0;
		}
		else{
			System.out.println("n3 is the greatest");
			return 0;
		}
	}
	public static int smallest(int n1,int n2,int n3) {
		if(n1<n2 && n1<n3) {
			System.out.println("n1 is the smallest");
			return 0;
		}
		else if(n2<n3 && n2<n3) {
			System.out.println("n2 is the smallest");
			return 0;
		}
		else{
			System.out.println("n3 is the smallest");
			return 0;
		}
	}
	
}
