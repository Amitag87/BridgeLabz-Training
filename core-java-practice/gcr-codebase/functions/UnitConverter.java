package functions;

import java.util.Scanner;

public class UnitConverter {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	double dist = sc.nextInt();
	double miles=km2miles(dist);
	double km=miles2km(miles);
	double m2feet=m2feet(dist);
	double feet2m=feet2m(m2feet);
}
public static double km2miles(double dist) {
	return dist*0.621371;
}
public static double miles2km(double km) {
	return km*1.60934;
}
public static double m2feet(double dist) {
	return dist*3.28084;
}
public static double feet2m(double m2feet) {
	return m2feet*1.60934;
}
}
