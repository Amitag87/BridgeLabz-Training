// Demo class for educational course hierarchy
public class EducationalSystem {
    public static void main(String[] args) {
        System.out.println("=== Educational Course Hierarchy ===");
        
        // Level 1: Basic Course
        Course course1 = new Course("Mathematics", 12);
        System.out.println("Basic Course:");
        course1.displayCourseInfo();
        System.out.println();
        
        // Level 2: Online Course
        OnlineCourse course2 = new OnlineCourse("Java Programming", 8, "Udemy", true);
        System.out.println("Online Course:");
        course2.displayCourseInfo();
        System.out.println();
        
        // Level 3: Paid Online Course
        PaidOnlineCourse course3 = new PaidOnlineCourse("Advanced Java", 10, "Coursera", true, 199.99, 20);
        System.out.println("Paid Online Course:");
        course3.displayCourseInfo();
    }
}