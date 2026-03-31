package functions;

import java.util.Scanner;

public class CollinearPoints {

    public static boolean checkCollinearSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        int dx1 = x2 - x1;
        int dy1 = y2 - y1;
        int dx2 = x3 - x2;
        int dy2 = y3 - y2;

        return (dx1 * dy2) == (dx2 * dy1);
    }

    public static boolean checkCollinearArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        System.out.println("Collinear by slope: " + checkCollinearSlope(x1, y1, x2, y2, x3, y3));
        System.out.println("Collinear by area: " + checkCollinearArea(x1, y1, x2, y2, x3, y3));

        sc.close();
    }
}

