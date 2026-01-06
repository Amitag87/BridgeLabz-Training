import java.util.ArrayList;
import java.util.List;
class Student{
    private String name;
    private String studentId;
    public Student(String name, String studentId){
        this.name=name;
        this.studentId=studentId;
    }
    public String getName(){
        return name;
    }
    public String getStudentId(){
        return studentId;
    }
}
public class Course {
    private String courseName;
    private String courseCode;
    private int credits;
    public List<Student> enrolledStudents;
    public Course(String courseName, String courseCode, int credits, List<Student> enrolledStudents){
        this.courseCode=courseCode;
        this.courseName=courseName;
        this.credits=credits;
        this.enrolledStudents=new ArrayList<>();
    }
    public String getCourseName(){
        return courseName;
    }
    public String courseCode(){
        return courseCode;
    }
    public int credits(){
        return credits;
    } 
    public void enrolledStudents(Student student){
        enrolledStudents.add(student);
        System.out.println(student.getName()+" has been enrolled in "+courseName);
    }
    public void showEnrolledStudents(){
        System.out.println("Enrolled Students in "+courseName+":");
        for(Student student: enrolledStudents){
            System.out.println("Name: "+student.getName()+", Student ID: "+student.getStudentId());
        }
    }
    public static void main(String[] args){
        Course course1=new Course("Data Structures","CS101",4,new ArrayList<>());
        Student student1=new Student("Alice","S1001");
        Student student2=new Student("Bob","S1002");
        course1.enrolledStudents(student1);
        course1.enrolledStudents(student2);
        course1.showEnrolledStudents();
        Course course2=new Course("Cloud Computing","BCS002",3,new ArrayList<>());
        Student student3=new Student("Hodophile","1008");
        course2.enrolledStudents(student3);
        course2.showEnrolledStudents();
    }
}


   

