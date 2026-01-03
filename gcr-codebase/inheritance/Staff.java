// Staff extends Person
public class Staff extends Person {
    private String department;
    private String position;
    
    public Staff(String name, int age, String department, String position) {
        super(name, age);
        this.department = department;
        this.position = position;
    }
    
    @Override
    public void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department + ", Position: " + position);
    }
}