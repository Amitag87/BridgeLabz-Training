package strings;

import java.util.Scanner;

public class BMICalculator {

    public static String[] calculateBMIAndStatus(double weightKg, double heightCm) {
        double heightMeter = heightCm / 100;
        double bmi = weightKg / (heightMeter * heightMeter);
        bmi = Math.round(bmi * 100.0) / 100.0;

        String status;
        if (bmi < 18.5)
            status = "Underweight";
        else if (bmi < 25)
            status = "Normal";
        else if (bmi < 30)
            status = "Overweight";
        else
            status = "Obese";

        return new String[]{
                String.valueOf(heightCm),
                String.valueOf(weightKg),
                String.valueOf(bmi),
                status
        };
    }

    // Method to process all persons
    public static String[][] processBMI(double[][] data) {
        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            result[i] = calculateBMIAndStatus(data[i][0], data[i][1]);
        }
        return result;
    }

    // Method to display BMI table
    public static void displayBMIReport(String[][] report) {
        System.out.println("\nBMI REPORT");
        System.out.println("----------------------------------------------");
        System.out.println("Person\tHeight(cm)\tWeight(kg)\tBMI\tStatus");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < report.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                    report[i][0] + "\t\t" +
                    report[i][1] + "\t\t" +
                    report[i][2] + "\t" +
                    report[i][3]
            );
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] inputData = new double[10][2]; // weight, height

        try {
            for (int i = 0; i < 10; i++) {
                System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
                inputData[i][0] = scanner.nextDouble();

                System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
                inputData[i][1] = scanner.nextDouble();
            }

            String[][] bmiReport = processBMI(inputData);
            displayBMIReport(bmiReport);

        } catch (Exception e) {
            System.out.println("Invalid input!");
        } finally {
            scanner.close();
        }
    }
}
