// Demo class for school system
public class SchoolSystem {
    public static void main(String[] args) {
        System.out.println("=== School System (Hierarchical Inheritance) ===");
        
        // All three subclasses inherit from Person
        Teacher teacher = new Teacher("Ms. Johnson", 35, "Mathematics", 10);
        Student student = new Student("John Smith", 16, "10th Grade", "STU001");
        Staff staff = new Staff("Mr. Brown", 45, "Administration", "Office Manager");
        
        System.out.println("Teacher Information:");
        teacher.displayPersonInfo();
        teacher.displayRole();
        System.out.println();
        
        System.out.println("Student Information:");
        student.displayPersonInfo();
        student.displayRole();
        System.out.println();
        
        System.out.println("Staff Information:");
        staff.displayPersonInfo();
        staff.displayRole();
    }
}