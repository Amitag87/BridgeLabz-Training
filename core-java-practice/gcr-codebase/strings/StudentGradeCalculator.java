package strings;

import java.util.Scanner;

public class StudentGradeCalculator {

    public static int[][] generatePCMMarks(int studentCount) {
        int[][] marks = new int[studentCount][3];

        for (int i = 0; i < studentCount; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = (int) (Math.random() * 90) + 10; // 10–99
            }
        }
        return marks;
    }

    public static double[][] calculateResults(int[][] marks) {
        double[][] results = new double[marks.length][3];

        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    public static String[] calculateGrades(double[][] results) {
        String[] grades = new String[results.length];

        for (int i = 0; i < results.length; i++) {
            double percentage = results[i][2];

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

    public static void displayScorecard(int[][] marks, double[][] results, String[] grades) {
        System.out.println("\nSTUDENT SCORECARD");
