import java.util.Scanner;
import java.util.ArrayList;

public class StudentScoreManager {
    
    public static void analyzeScores(double[] scores) {
        if (scores == null || scores.length == 0) {
            System.out.println("No scores to analyze");
            return;
        }
        
        double sum = 0, highest = scores[0], lowest = scores[0];
        
        for (double score : scores) {
            sum += score;
            if (score > highest) highest = score;
            if (score < lowest) lowest = score;
        }
        
        double average = sum / scores.length;
        
        System.out.printf("Average score: %.2f%n", average);
        System.out.printf("Highest score: %.2f%n", highest);
        System.out.printf("Lowest score: %.2f%n", lowest);
        
        System.out.print("Scores above average: ");
        boolean found = false;
        for (double score : scores) {
            if (score > average) {
                System.out.printf("%.2f ", score);
                found = true;
            }
        }
        if (!found) System.out.print("None");
        System.out.println();
    }
    
    public static double[] inputScores() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> scoreList = new ArrayList<>();
        
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.print("Enter score for student " + (i + 1) + ": ");
                    double score = scanner.nextDouble();
                    
                    if (score < 0) {
                        System.out.println("Score cannot be negative. Please enter again.");
                        continue;
                    }
                    
                    scoreList.add(score);
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear invalid input
                }
            }
        }
        
        return scoreList.stream().mapToDouble(Double::doubleValue).toArray();
    }
    
    public static void main(String[] args) {
        // Sample data for testing
        double[] sampleScores = {85.5, 92.0, 78.5, 95.0, 88.0, 76.5, 91.5, 83.0};
        
        System.out.println("Sample Score Analysis:");
        analyzeScores(sampleScores);
        System.out.println();
        
        // Interactive input
        System.out.println("Interactive Score Input:");
        double[] userScores = inputScores();
        analyzeScores(userScores);
    }
}