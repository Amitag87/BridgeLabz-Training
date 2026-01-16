import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        FullTimeEmployee ft1 = new FullTimeEmployee("FT001", "John Doe", 5000);
        ft1.assignDepartment("Engineering");
        
        PartTimeEmployee pt1 = new PartTimeEmployee("PT001", "Jane Smith", 25, 80);
        pt1.assignDepartment("Marketing");
        
        employees.add(ft1);
        employees.add(pt1);
        
        System.out.println("=== Employee Management System ===");
        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Department) {
                System.out.println("Department: " + ((Department) emp).getDepartmentDetails());
            }
            System.out.println();
        }
    }
}