public class Intern extends Employee {
    private int duration;
    
    public Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: $" + salary);
        System.out.println("Role: Intern, Duration: " + duration + " months");
    }
}