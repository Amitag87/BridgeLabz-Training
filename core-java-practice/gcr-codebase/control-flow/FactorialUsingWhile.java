import java.util.Scanner;
public class FactorialUsingWhile {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        int factorial = 1;
        int i = 1;
        while (i <= number) {
            factorial = factorial * i;
            i++;
        }
        System.out.println("The factorial of " + number + " is " + factorial);
    }
}