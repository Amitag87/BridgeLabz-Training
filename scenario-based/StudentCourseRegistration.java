import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentCourseRegistration {
    public static void main(String[] args) {
        try {
            Course c1 = new Course("C101", "Data Structures");
            Course c2 = new Course("C102", "Algorithms");
            
            Person p1 = new Person("Parv Bhai GLA wale", "parv@google.com");
            Student s1 = new Student("S1001", p1);
            
            RegistrationSystem regSystem = new RegistrationSystem();
            
            s1.enrollCourse(c1);
            s1.enrollCourse(c2);
            
            s1.viewEnrolledCourses();
            
            regSystem.addGrade(s1.getStudentID(), "C101", "A");
            regSystem.addGrade(s1.getStudentID(), "C102", "B+");
            
            s1.viewGrades(regSystem);
            
            s1.dropCourse("C102");
            
            System.out.println("\nAfter dropping C102:");
            s1.viewEnrolledCourses();
            
        } catch (CourseLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
class CourseLimitExceededException extends Exception{
    public CourseLimitExceededException(String message){
        super(message);
    }
}
class Person{
    private String name;
    private String email;
    public Person(String name, String email){
        this.name=name;
        this.email=email;
    }
    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }
}
abstract class RegistrationService {
    abstract void registerStudentToCourse(Student student, Course course);
    abstract void addGrade(String studentID, String courseId, String grade);
}
class Student extends Person {
    private String studentID;
    private ArrayList<Course> enrolledCourses;
    private static final int MAX_COURSES = 5;
    
    public Student(String studentID, Person person) {
        super(person.getName(), person.getEmail());
        this.studentID = studentID;
        this.enrolledCourses = new ArrayList<>();
    }
    
    public String getStudentID() {
        return studentID;
    }
    
    public void enrollCourse(Course course) throws CourseLimitExceededException {
        if (enrolledCourses.size() >= MAX_COURSES) {
            throw new CourseLimitExceededException("Student has already registered for " + MAX_COURSES + " courses");
        }
        enrolledCourses.add(course);
        System.out.println("Enrolled in: " + course.getCourseName());
    }
    
    public void dropCourse(String courseId) {
        enrolledCourses.removeIf(course -> course.getCourseId().equals(courseId));
        System.out.println("Dropped course: " + courseId);
    }
    
    public void viewEnrolledCourses() {
        System.out.println("\nEnrolled Courses for " + getName() + ":");
        for (Course course : enrolledCourses) {
            System.out.println("- " + course.getCourseId() + ": " + course.getCourseName());
        }
    }
    
    public void viewGrades(RegistrationSystem regSystem) {
        System.out.println("\nGrades for " + getName() + ":");
        regSystem.displayGrades(studentID);
    }
}
class Course {
    private String courseId;
    private String courseName;
    
    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }
    
    public String getCourseId() {
        return courseId;
    }
    
    public String getCourseName() {
        return courseName;
    }
}
class Grade {
    private String courseId;
    private String studentID;
    private String grade;
    
    public Grade(String courseId, String studentID, String grade) {
        this.courseId = courseId;
        this.studentID = studentID;
        this.grade = grade;
    }
    
    public String getCourseId() {
        return courseId;
    }
    
    public String getStudentID() {
        return studentID;
    }
    
    public String getGrade() {
        return grade;
    }
}
class RegistrationSystem extends RegistrationService {
    private Map<String, ArrayList<Grade>> studentGrades;
    
    public RegistrationSystem() {
        this.studentGrades = new HashMap<>();
    }
    
    @Override
    public void registerStudentToCourse(Student student, Course course) {
        try {
            student.enrollCourse(course);
        } catch (CourseLimitExceededException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }
    
    @Override
    public void addGrade(String studentID, String courseId, String grade) {
        studentGrades.computeIfAbsent(studentID, k -> new ArrayList<>())
                    .add(new Grade(courseId, studentID, grade));
        System.out.println("Grade " + grade + " added for course " + courseId);
    }
    
    public void displayGrades(String studentID) {
        ArrayList<Grade> grades = studentGrades.get(studentID);
        if (grades != null) {
            for (Grade grade : grades) {
                System.out.println("Course " + grade.getCourseId() + ": " + grade.getGrade());
            }
        } else {
            System.out.println("No grades found");
        }
    }
}