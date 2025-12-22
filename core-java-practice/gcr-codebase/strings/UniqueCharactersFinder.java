package strings;

import java.util.Scanner;

public class UniqueCharactersFinder {

    public static int findTextLength(String text) {
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

      public static char[] findUniqueCharacters(String text) {
        int length = findTextLength(text);
        char[] temp = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[uniqueCount++] = currentChar;
            }
        }

        // Create exact-size array for unique characters
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = temp[i];
        }

        return uniqueChars;
    }

    public static void displayUniqueCharacters(char[] uniqueChars) {
        System.out.println("\nUnique Characters:");
        for (char ch : uniqueChars) {
            System.out.print(ch + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

            char[] uniqueCharacters = findUniqueCharacters(text);
            displayUniqueCharacters(uniqueCharacters);

        } catch (Exception e) {
            System.out.println("Invalid input!");
        } finally {
            scanner.close();
        }
    }
}
