package strings;

import java.util.Scanner;

public class StringIndexOutOfBounds{

   
    public static void generateException(String text) {
       
        System.out.println(text.charAt(text.length())); 
    }

    
    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled: Invalid index access");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

   
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        
        System.out.println("\nGenerating Exception:");
        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main method");
        }

        
        System.out.println("\nHandling Exception:");
        handleException(text);

        sc.close();
    }
}
