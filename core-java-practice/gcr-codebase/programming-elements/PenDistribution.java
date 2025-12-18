package BridgeLab;
import java.util.*;
public class PenDistribution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pens=sc.nextInt();
		int students=sc.nextInt();
		int rem=pens%students;
		int exactPens=pens-rem;
		System.out.print("The pen per student is "+exactPens/students +" and the remaining pen not distributed is "+rem);
		
}
}
