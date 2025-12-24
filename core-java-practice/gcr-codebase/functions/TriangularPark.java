package functions;

import java.util.Scanner;

public class TriangularPark {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int s1=sc.nextInt();
		int s2=sc.nextInt();
		int s3=sc.nextInt();
		double p=perimeter(s1,s2,s3);
		double rounds=p/5;
		System.out.println(rounds);
	}
	public static int perimeter(int s1, int s2,int s3) {
		return s1+s2+s3;
	}
}
