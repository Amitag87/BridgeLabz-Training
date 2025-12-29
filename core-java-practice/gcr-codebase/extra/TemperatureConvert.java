import java.util.Scanner;

class TemperatureConvert {
    static double toCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    static double toFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double value = scn.nextDouble();
        System.out.println(toCelsius(value));
        System.out.println(toFahrenheit(value));
        scn.close();
    }
}
