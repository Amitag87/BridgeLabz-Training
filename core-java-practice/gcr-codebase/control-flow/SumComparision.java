import java.util.*;
public class SumComparision {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int sumUsingFormula = n * (n + 1) / 2;
	        int sumUsingLoop = 0;
	        while (n >= 1) {
	            sumUsingLoop += n;
	            n--;
	        }
	        if (sumUsingFormula == sumUsingLoop) {
	            System.out.println("Both methods give the same sum");
	        } else {
	            System.out.println("Both sums are different.");
	        }
	    }
}
