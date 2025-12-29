import java.util.Scanner;

class MaxOfThree {
    static int findMax(int a, int b, int c) {
        int max = a;
        if (b > max)
            max = b;
        if (c > max)
            max = c;
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int n3 = scn.nextInt();
        System.out.println("Maximum is " + findMax(n1, n2, n3));
        scn.close();
    }
}
