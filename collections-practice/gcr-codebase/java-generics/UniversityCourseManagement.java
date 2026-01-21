import java.util.*;

abstract class CourseType {
    String evaluationType;
    
    CourseType(String evaluationType) {
        this.evaluationType = evaluationType;
    }
    
    abstract void displayEvaluation();
}

class ExamCourse extends CourseType {
    ExamCourse() {
        super("Exam-Based");
    }
    
    void displayEvaluation() {
        System.out.println("Evaluation: Written Exams and Quizzes");
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse() {
        super("Assignment-Based");
    }
    
    void displayEvaluation() {
        System.out.println("Evaluation: Projects and Assignments");
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse() {
        super("Research-Based");
    }
    
    void displayEvaluation() {
        System.out.println("Evaluation: Research Papers and Thesis");
    }
}

class Course<T extends CourseType> {
    String courseName;
    String department;
    T courseType;
    
    Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }
    
    void displayCourse() {
        System.out.println("Course: " + courseName + " [" + department + "]");
        System.out.println("Type: " + courseType.evaluationType);
        courseType.displayEvaluation();
    }
}

public class UniversityCourseManagement {
    public static void displayAllCourses(List<? extends Course<? extends CourseType>> courses) {
        System.out.println("=== All University Courses ===");
        for (Course<? extends CourseType> course : courses) {
            course.displayCourse();
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Course<ExamCourse> mathCourse = new Course<>("Calculus", "Mathematics", new ExamCourse());
        Course<AssignmentCourse> csCourse = new Course<>("Software Engineering", "Computer Science", new AssignmentCourse());
        Course<ResearchCourse> physicsCourse = new Course<>("Quantum Physics", "Physics", new ResearchCourse());
        
        List<Course<? extends CourseType>> allCourses = new ArrayList<>();
        allCourses.add(mathCourse);
        allCourses.add(csCourse);
        allCourses.add(physicsCourse);
        
        displayAllCourses(allCourses);
    }
}