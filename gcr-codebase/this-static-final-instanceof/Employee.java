public class Employee {
    private static String companyName = "Tech Solutions Inc.";
    private static int totalEmployees = 0;
    
    private final int id;
    private String name;
    private String designation;
    
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }
    
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
    
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }
    
    public static void main(String[] args) {
        Employee emp1 = new Employee("Thamarai", 101, "Software Engineer");
        Employee emp2 = new Employee("Rohan", 102, "Project Manager");
        
        Employee.displayTotalEmployees();
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
    }
}