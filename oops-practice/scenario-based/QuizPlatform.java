import java.util.ArrayList;
import java.util.List;

public class QuizPlatform {
    private String[] correctAnswers;
    private List<Integer> userScores = new ArrayList<>();
    
    public QuizPlatform(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }
    
    public int compareAnswers(String[] userAnswers) throws InvalidQuizSubmissionException {
        if (userAnswers.length != correctAnswers.length) {
            throw new InvalidQuizSubmissionException("Answer length mismatch");
        }
        
        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equals(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }
    
    public int calculateScore(String[] userAnswers) throws InvalidQuizSubmissionException {
        return compareAnswers(userAnswers);
    }
    
    public String getGrade(int score) {
        double percentage = (score * 100.0) / correctAnswers.length;
        if (percentage >= 90) return "A";
        else if (percentage >= 80) return "B";
        else if (percentage >= 70) return "C";
        else if (percentage >= 60) return "D";
        else return "F";
    }
    
    public void processQuiz(String[] userAnswers) {
        try {
            int score = calculateScore(userAnswers);
            userScores.add(score);
            String grade = getGrade(score);
            System.out.println("Score: " + score + "/" + correctAnswers.length + ", Grade: " + grade);
        } catch (InvalidQuizSubmissionException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void displayAllScores() {
        System.out.println("All Scores: " + userScores);
    }
    
    public static void main(String[] args) {
        String[] correct = {"A", "B", "C", "D", "A"};
        QuizPlatform quiz = new QuizPlatform(correct);
        
        String[] user1 = {"A", "B", "C", "D", "A"};
        String[] user2 = {"A", "C", "C", "D", "B"};
        String[] user3 = {"A", "B"}; // Invalid length
        
        quiz.processQuiz(user1);
        quiz.processQuiz(user2);
        quiz.processQuiz(user3);
        
        quiz.displayAllScores();
    }
}