package strings;

import java.util.Scanner;

public class NumberFormatExceptions {
    public static void generateException(String text) {
        int number = Integer.parseInt(text); // causes exception
        System.out.println(number);
    }

   
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled: Invalid number format");
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException handled");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string value: ");
        String text = sc.nextLine();

       
        System.out.println("\nGenerating Exception:");
        try {
            generateException(text);
        } catch (NumberFormatException e) {
            System.out.println("Exception caught in main method");
        }

        System.out.println("\nHandling Exception:");
        handleException(text);

        sc.close();
    }
}
