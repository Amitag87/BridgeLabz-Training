package functions;

public class UnitConvertor {

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        double fahrenheit2celsius = (fahrenheit - 32) * 5 / 9;
        return fahrenheit2celsius;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        double celsius2fahrenheit = (celsius * 9 / 5) + 32;
        return celsius2fahrenheit;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = pounds * 0.453592;
        return pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = kilograms * 2.20462;
        return kilograms2pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = gallons * 3.78541;
        return gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = liters * 0.264172;
        return liters2gallons;
    }
    public static void main(String[] args) {
        System.out.println(UnitConvertor.convertFahrenheitToCelsius(98.6));
        System.out.println(UnitConvertor.convertKilogramsToPounds(10));
        System.out.println(UnitConvertor.convertLitersToGallons(5));
    }
}
