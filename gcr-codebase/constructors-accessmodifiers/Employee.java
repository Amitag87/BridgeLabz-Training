public class Employee {
    public int employeeID;
    protected String department;
    private double salary;
    
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void displayDetails() {
        System.out.println("ID: " + employeeID + ", Department: " + department + ", Salary: $" + salary);
    }
}

class Manager extends Employee {
    int teamSize;
    
    public Manager(int employeeID, String department, double salary, int teamSize) {
        super(employeeID, department, salary);
        this.teamSize = teamSize;
    }
    
    public void displayManagerDetails() {
        System.out.println("Manager ID: " + employeeID + ", Department: " + department + ", Team Size: " + teamSize);
    }
    
    public static void main(String[] args) {
        Employee emp = new Employee(101, "IT", 50000.0);
        emp.displayDetails();
        emp.setSalary(55000.0);
        System.out.println("Updated Salary: $" + emp.getSalary());
        
        Manager mgr = new Manager(201, "Engineering", 80000.0, 10);
        mgr.displayManagerDetails();
    }
}