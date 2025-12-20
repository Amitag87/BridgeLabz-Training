import java.util.Scanner;

class PowerCalculationUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int power = sc.nextInt();
        int result = 1;
        if (number > 0 && power >= 0) {
            int counter = 0;
            while (counter < power) {
                result = result * number;
                counter++;
            }
            System.out.println("The power result is " + result);
        } else {
            System.out.println("Invalid input");
        }
    }
}
