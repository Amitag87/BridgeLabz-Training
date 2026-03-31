import java.util.Scanner;

class FactorialRecursion {
    static int factorial(int number) {
        if (number == 0)
            return 1;
        return number * factorial(number - 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        System.out.println(factorial(number));
        scn.close();
    }
}
