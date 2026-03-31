public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee[] employees = {
            new Manager("Alice Johnson", 101, 80000, 10),
            new Developer("Bob Smith", 102, 70000, "Java"),
            new Intern("Charlie Brown", 103, 25000, 6)
        };
        
        System.out.println("Employee Management System");
        System.out.println("==========================");
        
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println();
        }
    }
}