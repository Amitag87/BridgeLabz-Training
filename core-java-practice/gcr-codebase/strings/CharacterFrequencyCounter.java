package strings;

import java.util.Scanner;

public class CharacterFrequencyCounter {

    public static String[][] findCharacterFrequencies(String text) {
        int[] frequency = new int[256]; // ASCII characters

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] > 0) {
                uniqueCount++;
                frequency[text.charAt(i)] = -frequency[text.charAt(i)]; // mark visited
            }
        }

        for (int i = 0; i < 256; i++) {
            if (frequency[i] < 0) {
                frequency[i] = -frequency[i];
            }
        }

        String[][] result = new String[uniqueCount][2];
        int index = 0;

        boolean[] visited = new boolean[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!visited[ch]) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(frequency[ch]);
                visited[ch] = true;
                index++;
            }
        }

        return result;
    }

    public static void displayFrequencies(String[][] frequencies) {
        System.out.println("\nCharacter Frequency:");
        System.out.println("--------------------");
        System.out.println("Character\tCount");

        for (String[] row : frequencies) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

            String[][] frequencies = findCharacterFrequencies(text);
            displayFrequencies(frequencies);

        } catch (Exception e) {
            System.out.println("Invalid input!");
        } finally {
            scanner.close();
        }
    }
}
