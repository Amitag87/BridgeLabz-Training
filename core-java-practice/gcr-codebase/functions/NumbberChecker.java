package functions;
import java.util.Scanner;

public class NumbberChecker {

    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();

            if (isPositive(numbers[i])) {
                System.out.print("Positive number - ");
                if (isEven(numbers[i])) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            } else {
                System.out.println("Negative number");
            }
        }

        int result = compare(numbers[0], numbers[numbers.length - 1]);

        System.out.println("\nComparison of first and last elements:");
        if (result == 1) {
            System.out.println("First element is greater than last element");
        } else if (result == 0) {
            System.out.println("First and last elements are equal");
        } else {
            System.out.println("First element is less than last element");
        }

        sc.close();
    }
}
