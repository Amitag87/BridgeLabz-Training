package functions;

import java.util.Scanner;

public class SpringSeason {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int d=sc.nextInt();
		int m=sc.nextInt();
		checkSpring( d, m);
	}
	public static void checkSpring(int d, int m) {
		if(m==3 && d>=20 || m==6 && d<=20 || m>=4 && m<6) {
			System.out.println("Spring season h ye");
		}
		else {
			System.out.println("Not spring ssn");
		}
	}
}
