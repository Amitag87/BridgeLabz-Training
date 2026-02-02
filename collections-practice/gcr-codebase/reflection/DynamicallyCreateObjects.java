class Student{
    private String name;
    private int id;
    public Student(){
        name="Amit Aagarwal";
        id=101;
    }
    public void display(){
        System.out.println(name+" "+id);
    }
}
public class DynamicallyCreateObjects{
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("Student");
        Object obj = cls.getDeclaredConstructor().newInstance();
        Student student = (Student) obj;
        student.display();
    }
}