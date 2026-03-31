public class Manager extends Employee {
    private int teamSize;
    
    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: $" + salary);
        System.out.println("Role: Manager, Team Size: " + teamSize);
    }
}