public class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private String department;
    
    public PartTimeEmployee(String employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, hourlyRate);
        this.hoursWorked = hoursWorked;
    }
    
    @Override
    public double calculateSalary() {
        return baseSalary * hoursWorked; // Hourly rate * hours
    }
    
    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public String getDepartmentDetails() {
        return department != null ? department : "Not Assigned";
    }
    
    public int getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(int hoursWorked) { this.hoursWorked = hoursWorked; }
}