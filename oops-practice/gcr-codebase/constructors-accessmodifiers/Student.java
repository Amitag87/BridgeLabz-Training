public class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;
    
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }
    
    public double getCGPA() {
        return CGPA;
    }
    
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
    
    public void displayDetails() {
        System.out.println("Roll: " + rollNumber + ", Name: " + name + ", CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {
    String specialization;
    
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }
    
    public void displayPGDetails() {
        System.out.println("PG Student - Roll: " + rollNumber + ", Name: " + name + ", Specialization: " + specialization);
    }
    
    public static void main(String[] args) {
        Student s = new Student(101, "John", 8.5);
        s.displayDetails();
        s.setCGPA(9.0);
        System.out.println("Updated CGPA: " + s.getCGPA());
        
        PostgraduateStudent pg = new PostgraduateStudent(201, "Alice", 9.2, "AI");
        pg.displayPGDetails();
    }
}