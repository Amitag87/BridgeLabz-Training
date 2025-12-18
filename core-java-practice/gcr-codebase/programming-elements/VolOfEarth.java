package BridgeLab;
import java.util.*;
public class VolOfEarth {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt();
		double volKm=(4*3.14*r*r*r)/3;
		double volMiles=volKm*0.6;
		System.out.print("The volume of earth in cubic km is: "+ volKm +" in cubic miles: "+ volMiles);
	}
}
