package BridgeLab;
import java.util.*;
public class SumUntilZeroOrNegative {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        double total = 0.0;
	        while (true) {
	            double value = sc.nextDouble();
	            if (value <= 0) {
	                break;
	            }
	            total = total + value;
	        }
	        System.out.println("The total value is " + total);
	    }
}
