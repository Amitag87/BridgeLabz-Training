// Base class for all people in school
public class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void displayPersonInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    public void displayRole() {
        System.out.println("Role: General Person");
    }
}