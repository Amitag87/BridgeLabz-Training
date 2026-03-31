package strings;

import java.util.Scanner;

public class CharacterOccurrenceFinder {

        public static int[] findCharacterIndexes(String text, char targetChar) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == targetChar) {
                count++;
            }
        }

        int[] indexes = new int[count];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == targetChar) {
                indexes[index++] = i;
            }
        }

        return indexes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a text: ");
            String text = scanner.nextLine();

            System.out.print("Enter a character to find occurrences: ");
            char character = scanner.next().charAt(0);

            int[] result = findCharacterIndexes(text, character);

            System.out.println("Indexes of character '" + character + "':");
            for (int index : result) {
                System.out.print(index + " ");
            }
        } catch (Exception e) {
            System.out.println("Invalid input!");
        } finally {
            scanner.close();
        }
    }
}
