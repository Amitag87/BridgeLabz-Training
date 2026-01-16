// Teacher extends Person
public class Teacher extends Person {
    private String subject;
    private int experience;
    
    public Teacher(String name, int age, String subject, int experience) {
        super(name, age);
        this.subject = subject;
        this.experience = experience;
    }
    
    @Override
    public void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject + ", Experience: " + experience + " years");
    }
}