import  java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class DivideByZero {
    public static void main(String[] args) {
        try {
            Scanner sc= new Scanner(System.in);
            try {
                 int num1 = sc.nextInt();
                 int num2 = sc.nextInt();
                 int result=num1/num2;
                 System.out.println("Result: "+result);
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid integers.");
                return;
            }
           
           
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is not allowed.");
        }
    }
}
