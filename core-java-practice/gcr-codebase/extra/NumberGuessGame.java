import java.util.Scanner;

class NumberGuessGame {
    static int generateGuess(int low, int high) {
        return low + (int) (Math.random() * (high - low + 1));
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int low = 1;
        int high = 100;

        while (true) {
            int guess = generateGuess(low, high);
            System.out.println("Computer guess " + guess);
            String feedback = scn.next();

            if (feedback.equals("correct")) {
                break;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            }
        }

        System.out.println("Game over");
        scn.close();
    }
}
