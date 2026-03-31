package functions;

import java.util.Scanner;

public class ChillTemp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double temp = sc.nextDouble();
        double windSpeed = sc.nextDouble();

        double result = windChill(temp, windSpeed);
        System.out.println("Wind Chill Temperature: " + result);
    }

    public static double windChill(double temp, double windSpeed) {
        double windChill = 35.74 + 0.6215 * temp
                + (0.4275 * temp - 35.75) * Math.pow(windSpeed, 0.16);
        return windChill;
    }
}
