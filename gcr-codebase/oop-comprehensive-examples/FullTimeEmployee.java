public class FullTimeEmployee extends Employee implements Department {
    private String department;
    
    public FullTimeEmployee(String employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }
    
    @Override
    public double calculateSalary() {
        return baseSalary; // Fixed salary for full-time
    }
    
    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public String getDepartmentDetails() {
        return department != null ? department : "Not Assigned";
    }
}