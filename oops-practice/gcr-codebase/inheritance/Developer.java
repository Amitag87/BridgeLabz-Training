public class Developer extends Employee {
    private String programmingLanguage;
    
    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: $" + salary);
        System.out.println("Role: Developer, Programming Language: " + programmingLanguage);
    }
}