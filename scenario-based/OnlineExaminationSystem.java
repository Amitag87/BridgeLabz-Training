import java.util.*;

// Exception Classes
class ExamTimeExpiredException extends Exception {
    public ExamTimeExpiredException(String message) {
        super(message);
    }
}

// Interface for evaluation strategy
interface EvaluationStrategy {
    int evaluate(List<String> answers, List<String> correctAnswers);
}

// Polymorphic evaluation implementations
class ObjectiveEvaluation implements EvaluationStrategy {
    @Override
    public int evaluate(List<String> answers, List<String> correctAnswers) {
        int score = 0;
        for (int i = 0; i < Math.min(answers.size(), correctAnswers.size()); i++) {
            if (answers.get(i).equalsIgnoreCase(correctAnswers.get(i))) {
                score += 2; // 2 marks per correct answer
            }
        }
        return score;
    }
}

class DescriptiveEvaluation implements EvaluationStrategy {
    @Override
    public int evaluate(List<String> answers, List<String> correctAnswers) {
        // Simplified descriptive evaluation (keyword matching)
        int score = 0;
        for (int i = 0; i < Math.min(answers.size(), correctAnswers.size()); i++) {
            String answer = answers.get(i).toLowerCase();
            String correct = correctAnswers.get(i).toLowerCase();
            
            String[] keywords = correct.split(" ");
            int matchCount = 0;
            for (String keyword : keywords) {
                if (answer.contains(keyword)) {
                    matchCount++;
                }
            }
            score += (matchCount * 10) / keywords.length; // Partial scoring
        }
        return score;
    }
}

// Core Classes
class Question {
    private String questionId;
    private String questionText;
    private String correctAnswer;
    private String type; // "objective" or "descriptive"
    
    public Question(String questionId, String questionText, String correctAnswer, String type) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.type = type;
    }
    
    // Getters
    public String getQuestionId() { return questionId; }
    public String getQuestionText() { return questionText; }
    public String getCorrectAnswer() { return correctAnswer; }
    public String getType() { return type; }
}

class Exam {
    private String examId;
    private String examName;
    private List<Question> questions;
    private int duration; // in minutes
    private boolean isActive;
    
    public Exam(String examId, String examName, int duration) {
        this.examId = examId;
        this.examName = examName;
        this.duration = duration;
        this.questions = new ArrayList<>();
        this.isActive = false;
    }
    
    public void addQuestion(Question question) {
        questions.add(question);
    }
    
    public void activateExam() { isActive = true; }
    public void deactivateExam() { isActive = false; }
    
    // Getters
    public String getExamId() { return examId; }
    public String getExamName() { return examName; }
    public List<Question> getQuestions() { return questions; }
    public int getDuration() { return duration; }
    public boolean isActive() { return isActive; }
}

class Student {
    private String studentId;
    private String name;
    private String email;
    
    public Student(String studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
    }
    
    // Getters
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}

class ExamSubmission {
    private String submissionId;
    private String studentId;
    private String examId;
    private List<String> answers;
    private long startTime;
    private long submitTime;
    private int score;
    
    public ExamSubmission(String submissionId, String studentId, String examId) {
        this.submissionId = submissionId;
        this.studentId = studentId;
        this.examId = examId;
        this.answers = new ArrayList<>();
        this.startTime = System.currentTimeMillis();
        this.score = -1; // Not evaluated yet
    }
    
    public void submitAnswers(List<String> answers) throws ExamTimeExpiredException {
        this.submitTime = System.currentTimeMillis();
        this.answers = new ArrayList<>(answers);
    }
    
    // Getters and Setters
    public String getSubmissionId() { return submissionId; }
    public String getStudentId() { return studentId; }
    public String getExamId() { return examId; }
    public List<String> getAnswers() { return answers; }
    public long getStartTime() { return startTime; }
    public long getSubmitTime() { return submitTime; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}

public class OnlineExaminationSystem {
    private Map<String, Exam> exams;
    private Map<String, Student> students;
    private Map<String, ExamSubmission> submissions;
    private Map<String, List<String>> enrollments; // examId -> list of studentIds
    
    public OnlineExaminationSystem() {
        this.exams = new HashMap<>();
        this.students = new HashMap<>();
        this.submissions = new HashMap<>();
        this.enrollments = new HashMap<>();
    }
    
    // CRUD Operations for Exams
    public void createExam(String examId, String examName, int duration) {
        Exam exam = new Exam(examId, examName, duration);
        exams.put(examId, exam);
        enrollments.put(examId, new ArrayList<>());
        System.out.println("Exam created: " + examName);
    }
    
    public void addQuestionToExam(String examId, Question question) {
        Exam exam = exams.get(examId);
        if (exam != null) {
            exam.addQuestion(question);
            System.out.println("Question added to exam: " + examId);
        }
    }
    
    // Student enrollment
    public void enrollStudent(String studentId, String examId) {
        if (exams.containsKey(examId) && students.containsKey(studentId)) {
            enrollments.get(examId).add(studentId);
            System.out.println("Student " + studentId + " enrolled in exam " + examId);
        }
    }
    
    public void registerStudent(String studentId, String name, String email) {
        Student student = new Student(studentId, name, email);
        students.put(studentId, student);
        System.out.println("Student registered: " + name);
    }
    
    // Answer submission
    public void startExam(String studentId, String examId) throws ExamTimeExpiredException {
        if (!enrollments.get(examId).contains(studentId)) {
            throw new ExamTimeExpiredException("Student not enrolled in this exam");
        }
        
        Exam exam = exams.get(examId);
        if (!exam.isActive()) {
            throw new ExamTimeExpiredException("Exam is not active");
        }
        
        String submissionId = studentId + "_" + examId;
        ExamSubmission submission = new ExamSubmission(submissionId, studentId, examId);
        submissions.put(submissionId, submission);
        
        System.out.println("Exam started for student: " + studentId);
    }
    
    public void submitExam(String studentId, String examId, List<String> answers) throws ExamTimeExpiredException {
        String submissionId = studentId + "_" + examId;
        ExamSubmission submission = submissions.get(submissionId);
        
        if (submission == null) {
            throw new ExamTimeExpiredException("No active exam session found");
        }
        
        Exam exam = exams.get(examId);
        long timeElapsed = (System.currentTimeMillis() - submission.getStartTime()) / (1000 * 60); // minutes
        
        if (timeElapsed > exam.getDuration()) {
            throw new ExamTimeExpiredException("Exam time has expired");
        }
        
        submission.submitAnswers(answers);
        System.out.println("Exam submitted by student: " + studentId);
    }
    
    // Result generation with polymorphic evaluation
    public void evaluateExam(String studentId, String examId) {
        String submissionId = studentId + "_" + examId;
        ExamSubmission submission = submissions.get(submissionId);
        Exam exam = exams.get(examId);
        
        if (submission == null || exam == null) {
            System.out.println("Submission or exam not found");
            return;
        }
        
        List<String> correctAnswers = new ArrayList<>();
        boolean hasDescriptive = false;
        
        for (Question q : exam.getQuestions()) {
            correctAnswers.add(q.getCorrectAnswer());
            if ("descriptive".equals(q.getType())) {
                hasDescriptive = true;
            }
        }
        
        EvaluationStrategy strategy = hasDescriptive ? 
            new DescriptiveEvaluation() : new ObjectiveEvaluation();
        
        int score = strategy.evaluate(submission.getAnswers(), correctAnswers);
        submission.setScore(score);
        
        System.out.println("Exam evaluated. Score: " + score);
    }
    
    public void displayResults(String studentId, String examId) {
        String submissionId = studentId + "_" + examId;
        ExamSubmission submission = submissions.get(submissionId);
        Student student = students.get(studentId);
        Exam exam = exams.get(examId);
        
        if (submission != null && student != null && exam != null) {
            System.out.println("\\n=== Exam Results ===");
            System.out.println("Student: " + student.getName());
            System.out.println("Exam: " + exam.getExamName());
            System.out.println("Score: " + submission.getScore());
            System.out.println("Status: " + (submission.getScore() >= 60 ? "PASS" : "FAIL"));
        }
    }
    
    public static void main(String[] args) {
        OnlineExaminationSystem system = new OnlineExaminationSystem();
        
        try {
            // Create exam
            system.createExam("E001", "Java Fundamentals", 60);
            
            // Add questions
            system.addQuestionToExam("E001", new Question("Q1", "What is OOP?", "A", "objective"));
            system.addQuestionToExam("E001", new Question("Q2", "Explain inheritance", "inheritance allows code reuse", "descriptive"));
            
            // Register student
            system.registerStudent("S001", "John Doe", "john@email.com");
            
            // Enroll student
            system.enrollStudent("S001", "E001");
            
            // Activate exam
            system.exams.get("E001").activateExam();
            
            // Start and submit exam
            system.startExam("S001", "E001");
            
            List<String> answers = Arrays.asList("A", "inheritance is a concept that allows code reuse");
            system.submitExam("S001", "E001", answers);
            
            // Evaluate and display results
            system.evaluateExam("S001", "E001");
            system.displayResults("S001", "E001");
            
        } catch (ExamTimeExpiredException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}