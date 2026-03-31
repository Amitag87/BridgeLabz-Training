import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    String department;
    double salary;
    
    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}

public class ObjectSerialization {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "John Doe", "IT", 50000),
            new Employee(2, "Jane Smith", "HR", 45000),
            new Employee(3, "Bob Johnson", "Finance", 55000)
        );
        
        // Serialize employees
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser"))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
        
        // Deserialize employees
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"))) {
            @SuppressWarnings("unchecked")
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            
            System.out.println("Deserialized employees:");
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
    }
}