package functions;
import java.util.*;
public class IsAbundant {


	    public static boolean isPerfectNumber(int number) {
	        if (number <= 0) return false;
	        int sum = 0;
	        for (int i = 1; i <= number / 2; i++) {
	            if (number % i == 0) {
	                sum += i;
	            }
	        }
	        return sum == number;
	    }

	    public static boolean isAbundantNumber(int number) {
	        if (number <= 0) return false;
	        int sum = 0;
	        for (int i = 1; i <= number / 2; i++) {
	            if (number % i == 0) {
	                sum += i;
	            }
	        }
	        return sum > number;
	    }

	    public static boolean isDeficientNumber(int number) {
	        if (number <= 0) return false;
	        int sum = 0;
	        for (int i = 1; i <= number / 2; i++) {
	            if (number % i == 0) {
	                sum += i;
	            }
	        }
	        return sum < number;
	    }

	    public static int factorial(int digit) {
	        int fact = 1;
	        for (int i = 1; i <= digit; i++) {
	            fact *= i;
	        }
	        return fact;
	    }

	    public static boolean isStrongNumber(int number) {
	        int sum = 0;
	        int temp = number;

	        while (temp != 0) {
	            int digit = temp % 10;
	            sum += factorial(digit);
	            temp /= 10;
	        }
	        return sum == number;
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        int number = sc.nextInt();

	        System.out.println(isPerfectNumber(number));
	        System.out.println(isAbundantNumber(number));
	        System.out.println(isDeficientNumber(number));
	        System.out.println(isStrongNumber(number));

	        sc.close();
	    }
	

}
