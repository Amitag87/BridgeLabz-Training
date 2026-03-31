import java.util.*;

class Question {
    int id;
    String question;
    String[] options;
    int correctAnswer;
    int marks;
    
    Question(int id, String question, String[] options, int correctAnswer, int marks) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.marks = marks;
    }
}

public class ExamProctor {
    private String studentId;
    private Stack<Integer> navigationStack;
    private HashMap<Integer, Integer> answers;
    private HashMap<Integer, Question> questionBank;
    private int currentQuestion;
    private boolean examSubmitted;
    
    public ExamProctor(String studentId) {
        this.studentId = studentId;
        this.navigationStack = new Stack<>();
        this.answers = new HashMap<>();
        this.questionBank = new HashMap<>();
        this.currentQuestion = -1;
        this.examSubmitted = false;
        initializeQuestions();
    }
    
    private void initializeQuestions() {
        questionBank.put(1, new Question(1, "What is 2 + 2?", 
            new String[]{"3", "4", "5", "6"}, 1, 2));
        questionBank.put(2, new Question(2, "Capital of India?", 
            new String[]{"Mumbai", "Delhi", "Kolkata", "Chennai"}, 1, 3));
        questionBank.put(3, new Question(3, "Java is platform independent?", 
            new String[]{"True", "False"}, 0, 2));
        questionBank.put(4, new Question(4, "Which is not a primitive type?", 
            new String[]{"int", "String", "boolean", "char"}, 1, 4));
        questionBank.put(5, new Question(5, "What is OOP?", 
            new String[]{"Object Oriented Programming", "Only One Program", "Open Office Program", "None"}, 0, 3));
    }
    
    public void navigateToQuestion(int questionId) {
        if (!questionBank.containsKey(questionId)) {
            System.out.println("Invalid question ID: " + questionId);
            return;
        }
        
        if (currentQuestion != -1) {
            navigationStack.push(currentQuestion);
        }
        
        currentQuestion = questionId;
        displayCurrentQuestion();
    }
    
    public void goToPreviousQuestion() {
        if (navigationStack.isEmpty()) {
            System.out.println("No previous question in navigation history!");
            return;
        }
        
        currentQuestion = navigationStack.pop();
        displayCurrentQuestion();
    }
    
    public void answerQuestion(int questionId, int selectedOption) {
        if (!questionBank.containsKey(questionId)) {
            System.out.println("Invalid question ID!");
            return;
        }
        
        Question q = questionBank.get(questionId);
        if (selectedOption < 0 || selectedOption >= q.options.length) {
            System.out.println("Invalid option selected!");
            return;
        }
        
        answers.put(questionId, selectedOption);
        System.out.println("Answer saved for Question " + questionId + ": " + q.options[selectedOption]);
    }
    
    public void displayCurrentQuestion() {
        if (currentQuestion == -1) {
            System.out.println("No question selected!");
            return;
        }
        
        Question q = questionBank.get(currentQuestion);
        System.out.println("\n=== Question " + q.id + " ===");
        System.out.println(q.question);
        for (int i = 0; i < q.options.length; i++) {
            System.out.println((i) + ". " + q.options[i]);
        }
        
        if (answers.containsKey(q.id)) {
            System.out.println("Your answer: " + q.options[answers.get(q.id)]);
        } else {
            System.out.println("Not answered yet");
        }
        System.out.println("Marks: " + q.marks);
        System.out.println("===================\n");
    }
    
    public void showNavigationHistory() {
        System.out.println("\n=== Navigation History ===");
        System.out.println("Current: Q" + currentQuestion);
        System.out.print("History: ");
        
        if (navigationStack.isEmpty()) {
            System.out.println("Empty");
        } else {
            Stack<Integer> temp = new Stack<>();
            while (!navigationStack.isEmpty()) {
                temp.push(navigationStack.pop());
            }
            while (!temp.isEmpty()) {
                int q = temp.pop();
                System.out.print("Q" + q + " ");
                navigationStack.push(q);
            }
            System.out.println();
        }
        System.out.println("==========================\n");
    }
    
    public void showAnswerSheet() {
        System.out.println("\n=== Answer Sheet ===");
        for (int qId : questionBank.keySet()) {
            Question q = questionBank.get(qId);
            String answer = answers.containsKey(qId) ? q.options[answers.get(qId)] : "Not Answered";
            System.out.println("Q" + qId + ": " + answer);
        }
        System.out.println("====================\n");
    }
    
    public int calculateScore() {
        int totalScore = 0;
        int maxScore = 0;
        
        for (Question q : questionBank.values()) {
            maxScore += q.marks;
            if (answers.containsKey(q.id) && answers.get(q.id) == q.correctAnswer) {
                totalScore += q.marks;
            }
        }
        
        return totalScore;
    }
    
    public void submitExam() {
        if (examSubmitted) {
            System.out.println("Exam already submitted!");
            return;
        }
        
        examSubmitted = true;
        int score = calculateScore();
        int maxScore = questionBank.values().stream().mapToInt(q -> q.marks).sum();
        double percentage = (score * 100.0) / maxScore;
        
        System.out.println("\n=== EXAM SUBMITTED ===");
        System.out.println("Student ID: " + studentId);
        System.out.println("Questions Attempted: " + answers.size() + "/" + questionBank.size());
        System.out.println("Score: " + score + "/" + maxScore);
        System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
        System.out.println("Grade: " + getGrade(percentage));
        System.out.println("======================\n");
    }
    
    private String getGrade(double percentage) {
        if (percentage >= 90) return "A+";
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        return "F";
    }
    
    public static void main(String[] args) {
        ExamProctor exam = new ExamProctor("STU001");
        
        // Navigate through questions
        exam.navigateToQuestion(1);
        exam.answerQuestion(1, 1); // Correct answer
        
        exam.navigateToQuestion(3);
        exam.answerQuestion(3, 0); // Correct answer
        
        exam.navigateToQuestion(2);
        exam.answerQuestion(2, 1); // Correct answer
        
        exam.showNavigationHistory();
        
        // Go back to previous question
        exam.goToPreviousQuestion();
        
        exam.navigateToQuestion(4);
        exam.answerQuestion(4, 0); // Wrong answer
        
        exam.navigateToQuestion(5);
        exam.answerQuestion(5, 0); // Correct answer
        
        exam.showAnswerSheet();
        exam.showNavigationHistory();
        
        // Submit exam
        exam.submitExam();
    }
}