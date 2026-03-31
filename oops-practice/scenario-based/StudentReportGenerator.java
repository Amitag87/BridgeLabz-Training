import java.util.ArrayList;
import java.util.List;

public class StudentReportGenerator {
    private List<StudentRecord> students = new ArrayList<>();
    
    public void addStudent(String name, String[] subjects, int[] marks) {
        try {
            students.add(new StudentRecord(name, subjects, marks));
            System.out.println("Student " + name + " added successfully");
        } catch (InvalidMarkException e) {
            System.out.println("Error adding " + name + ": " + e.getMessage());
        }
    }
    
    public void generateAllReports() {
        for (StudentRecord student : students) {
            System.out.println(student.generateReport());
        }
    }
    
    public void displayClassSummary() {
        System.out.println("=== CLASS SUMMARY ===");
        for (StudentRecord student : students) {
            System.out.printf("%-15s: Avg=%.2f, Grade=%s\n", 
                student.getName(), student.calculateAverage(), student.getGrade());
        }
    }
    
    public static void main(String[] args) {
        StudentReportGenerator generator = new StudentReportGenerator();
        
        String[] subjects = {"Math", "Science", "English", "History"};
        
        generator.addStudent("Alice", subjects, new int[]{95, 87, 92, 88});
        generator.addStudent("Bob", subjects, new int[]{78, 82, 75, 80});
        generator.addStudent("Charlie", subjects, new int[]{65, 70, 68, 72});
        generator.addStudent("Invalid", subjects, new int[]{105, 90, 85, 88}); // Invalid mark
        
        generator.generateAllReports();
        generator.displayClassSummary();
    }
}