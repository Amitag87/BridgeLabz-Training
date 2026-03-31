// Waiter extends Person and implements Worker (Hybrid Inheritance)
public class Waiter extends Person implements Worker {
    private int tablesAssigned;
    
    public Waiter(String name, int age, int tablesAssigned) {
        super(name, age);
        this.tablesAssigned = tablesAssigned;
    }
    
    @Override
    public void performDuties() {
        System.out.println(name + " is serving " + tablesAssigned + " tables");
    }
    
    @Override
    public void displayRole() {
        System.out.println("Role: Waiter, Tables Assigned: " + tablesAssigned);
    }
}