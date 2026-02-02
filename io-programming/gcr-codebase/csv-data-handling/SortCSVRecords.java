import java.io.*;
import java.util.*;

public class SortCSVRecords {
    
    static class Employee {
        String id;
        String name;
        String department;
        double salary;
        
        public Employee(String id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
        
        @Override
        public String toString() {
            return String.format("%s,%s,%s,%.2f", id, name, department, salary);
        }
    }
    
    public static void main(String[] args) {
        createSampleCSV();
        sortAndDisplayTopEmployees();
    }
    
    private static void createSampleCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("employees.csv"))) {
            writer.println("ID,Name,Department,Salary");
            writer.println("1,John Doe,Engineering,75000.00");
            writer.println("2,Jane Smith,Marketing,65000.00");
            writer.println("3,Mike Johnson,Engineering,85000.00");
            writer.println("4,Sarah Wilson,HR,55000.00");
            writer.println("5,David Brown,Finance,70000.00");
            writer.println("6,Lisa Davis,Engineering,90000.00");
            writer.println("7,Tom Miller,Marketing,60000.00");
            writer.println("8,Amy Taylor,Finance,72000.00");
            writer.println("9,Chris Anderson,HR,58000.00");
            writer.println("10,Emma White,Engineering,95000.00");
        } catch (IOException e) {
            System.err.println("Error creating sample CSV: " + e.getMessage());
        }
    }
    
    private static void sortAndDisplayTopEmployees() {
        List<Employee> employees = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("employees.csv"))) {
            String line = reader.readLine(); // Skip header
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    employees.add(new Employee(
                        parts[0].trim(),
                        parts[1].trim(),
                        parts[2].trim(),
                        Double.parseDouble(parts[3].trim())
                    ));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            return;
        }
        
        // Sort by salary in descending order
        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));
        
        System.out.println("Top 5 Highest-Paid Employees:");
        System.out.println("ID,Name,Department,Salary");
        employees.stream()
                .limit(5)
                .forEach(System.out::println);
    }
}