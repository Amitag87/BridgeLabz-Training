// Chef extends Person and implements Worker (Hybrid Inheritance)
public class Chef extends Person implements Worker {
    private String specialty;
    
    public Chef(String name, int age, String specialty) {
        super(name, age);
        this.specialty = specialty;
    }
    
    @Override
    public void performDuties() {
        System.out.println(name + " is cooking " + specialty + " dishes");
    }
    
    @Override
    public void displayRole() {
        System.out.println("Role: Chef, Specialty: " + specialty);
    }
}