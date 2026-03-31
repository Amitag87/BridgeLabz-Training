import java.util.Scanner;

class SimpleCalculator {
    static double add(double a, double b) {
        return a + b;
    }
    static double sub(double a, double b) {
        return a - b;
    }
    static double mul(double a, double b) {
        return a * b;
    }
    static double div(double a, double b) {
        return a / b;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double first = scn.nextDouble();
        double second = scn.nextDouble();
        String op = scn.next();

        if (op.equals("+"))
            System.out.println(add(first, second));
        else if (op.equals("-"))
            System.out.println(sub(first, second));
        else if (op.equals("*"))
            System.out.println(mul(first, second));
        else if (op.equals("/"))
            System.out.println(div(first, second));
        else
            System.out.println("Invalid");

        scn.close();
    }
}
