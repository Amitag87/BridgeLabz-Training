import java.util.Scanner;

class FibonacciSeries {
    static void printFibonacci(int terms) {
        int first = 0;
        int second = 1;

        for (int count = 1; count <= terms; count++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int terms = scn.nextInt();
        printFibonacci(terms);
        scn.close();
    }
}
