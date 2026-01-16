// Student extends Person
public class Student extends Person {
    private String grade;
    private String studentId;
    
    public Student(String name, int age, String grade, String studentId) {
        super(name, age);
        this.grade = grade;
        this.studentId = studentId;
    }
    
    @Override
    public void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade + ", Student ID: " + studentId);
    }
}