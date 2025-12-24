package functions;

import java.util.Scanner;

public class TRigonometricFunctions {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double angle=sc.nextDouble();
		double radian=Math.toRadians(angle);
		double sine=sine(radian);
		double cosine=cosine(radian);
		double tangent=tangent(radian);
		System.out.println(sine);
		System.out.println(cosine);
		System.out.println(tangent);
	}
	public static double sine(double radian){
		double sine = Math.sin(radian);
		return sine;
        
//        double tangent = Math.tan(radian);
	}
	public static double cosine(double radian) {
		double cosine = Math.cos(radian);
		return cosine;
	}
	public static double tangent(double radian) {
		double tan = Math.tan(radian);
		return tan;
	}
	
}
