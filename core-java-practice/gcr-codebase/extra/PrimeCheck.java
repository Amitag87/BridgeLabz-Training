import java.util.Scanner;

class PrimeCheck {
    static boolean isPrime(int number) {
        if (number <= 1)
            return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        System.out.println(isPrime(number));
        scn.close();
    }
}
