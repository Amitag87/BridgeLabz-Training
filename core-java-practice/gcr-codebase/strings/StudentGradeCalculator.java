package gcrcodebase.strings;

import java.util.*;
public class StudentGradeCalculator {
    static int[][] generatePCMScores(int students) {

        int[][] scores = new int[students][3]; // P, C, M

        for (int i = 0; i < students; i++) {
            scores[i][0] = (int) (Math.random() * 100); // Physics
            scores[i][1] = (int) (Math.random() * 100); // Chemistry
            scores[i][2] = (int) (Math.random() * 100); // Maths
        }
        return scores;
    }

    static double[][] calculateResult(int[][] scores) {

        double[][] result = new double[scores.length][3]; 
        for (int i = 0; i < scores.length; i++) {

            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }

    static String[] calculateGrade(double[][] result) {

        String[] grades = new String[result.length];

        for (int i = 0; i < result.length; i++) {

            double percentage = result[i][2];

            if (percentage >= 80)
                grades[i] = "A";
            else if (percentage >= 70)
                grades[i] = "B";
            else if (percentage >= 60)
                grades[i] = "C";
            else if (percentage >= 50)
                grades[i] = "D";
            else if (percentage >= 40)
                grades[i] = "E";
            else
                grades[i] = "R";
        }
        return grades;
    }

    static void displayScoreCard(int[][] scores, double[][] result, String[] grades) {

        System.out.println("\nStudent\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("-------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                    scores[i][0] + "\t" +
                    scores[i][1] + "\t\t" +
                    scores[i][2] + "\t" +
                    (int) result[i][0] + "\t" +
                    result[i][1] + "\t" +
                    result[i][2] + "%\t\t" +
                    grades[i]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        int[][] scores = generatePCMScores(students);
        double[][] result = calculateResult(scores);
        String[] grades = calculateGrade(result);

        displayScoreCard(scores, result, grades);

        sc.close();
    }
}