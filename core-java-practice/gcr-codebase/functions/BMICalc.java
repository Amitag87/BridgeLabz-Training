package functions;

import java.util.Scanner;

public class BMICalc {
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];

            double heightMeter = heightCm / 100;

            double bmi = weight / (heightMeter * heightMeter);
            data[i][2] = bmi;
        }
    }
    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];

            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 25) {
                status[i] = "Normal";
            } else if (bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] personData = new double[10][3];

        for (int i = 0; i < personData.length; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            personData[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            personData[i][1] = sc.nextDouble();
        }

        calculateBMI(personData);
        String[] bmiStatus = getBMIStatus(personData);

        System.out.println("\nPerson\tWeight\tHeight\tBMI\t\tStatus");
        for (int i = 0; i < personData.length; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s\n",
                    (i + 1),
                    personData[i][0],
                    personData[i][1],
                    personData[i][2],
                    bmiStatus[i]);
        }

        sc.close();
    }
}
