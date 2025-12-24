package functions;

import java.util.Scanner;

public class SimpleInterest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double p=sc.nextDouble();
		double r=sc.nextDouble();
		double t=sc.nextDouble();
		System.out.println(si(p,r,t));
	}
	public static double si(double p,double r,double t) {
		return (p*r*t)/100;
	}
}
