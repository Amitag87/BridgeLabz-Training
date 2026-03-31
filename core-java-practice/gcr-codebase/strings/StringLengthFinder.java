package strings;

import java.util.Scanner;

public class StringLengthFinder {

    public static int findLengthWithoutBuiltIn(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.next();

        System.out.println("Length (User Method): " + findLengthWithoutBuiltIn(text));
        System.out.println("Length (Built-in): " + text.length());

        scanner.close();
    }
}
