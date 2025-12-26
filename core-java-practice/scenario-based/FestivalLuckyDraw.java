import java.util.Scanner;

public class FestivalLuckyDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int visitors = 0;

        while (true) {
            System.out.print("Enter lucky draw number (0 to stop): ");
            int number = sc.nextInt();

            if (number == 0) {
                break; 
            }

            if (number < 0) {
                System.out.println("Invalid input. Try again.");
                continue; 
            }

            visitors++;

            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("Congratulations! You won a gift 🎁");
            } else {
                System.out.println("Sorry, better luck next time!");
            }
        }

        System.out.println("Total visitors participated: " + visitors);
        sc.close();
    }
}
