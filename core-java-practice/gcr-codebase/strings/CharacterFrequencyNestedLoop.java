package strings;

import java.util.Scanner;

public class CharacterFrequencyNestedLoop {

    public static String[] findCharacterFrequency(String text) {

        char[] characters = text.toCharArray();
        int length = characters.length;
        int[] frequency = new int[length];

        for (int i = 0; i < length; i++) {
            if (characters[i] == '0') {
                continue;
            }

            frequency[i] = 1;

            for (int j = i + 1; j < length; j++) {
                if (characters[i] == characters[j]) {
                    frequency[i]++;
                    characters[j] = '0'; // Mark duplicate
                }
            }
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (characters[i] != '0') {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (characters[i] != '0') {
                result[index] = characters[i] + " : " + frequency[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[] output = findCharacterFrequency(text);

        System.out.println("\nCharacter Frequency:");
        System.out.println("--------------------");
        for (String value : output) {
            System.out.println(value);
        }

        sc.close();
    }
}
