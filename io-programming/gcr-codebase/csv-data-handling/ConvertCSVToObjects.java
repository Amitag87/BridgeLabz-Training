import java.io.*;
import java.util.*;

public class ConvertCSVToObjects {
    
    static class Student {
        private int id;
        private String name;
        private int age;
        private String email;
        private double gpa;
        
        public Student(int id, String name, int age, String email, double gpa) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
            this.gpa = gpa;
        }
        
        // Getters
        public int getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getEmail() { return email; }
        public double getGpa() { return gpa; }
        
        @Override
        public String toString() {
            return String.format("Student{id=%d, name='%s', age=%d, email='%s', gpa=%.2f}", 
                               id, name, age, email, gpa);
        }
    }
    
    public static void main(String[] args) {
        createSampleStudentCSV();
        List<Student> students = convertCSVToObjects();
        displayStudents(students);
    }
    
    private static void createSampleStudentCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("students.csv"))) {
            writer.println("ID,Name,Age,Email,GPA");
            writer.println("1,Alice Johnson,20,alice.johnson@university.edu,3.85");
            writer.println("2,Bob Smith,21,bob.smith@university.edu,3.42");
            writer.println("3,Carol Davis,19,carol.davis@university.edu,3.91");
            writer.println("4,David Wilson,22,david.wilson@university.edu,3.67");
            writer.println("5,Emma Brown,20,emma.brown@university.edu,3.78");
            writer.println("6,Frank Miller,21,frank.miller@university.edu,3.23");
            writer.println("7,Grace Taylor,19,grace.taylor@university.edu,3.95");
            writer.println("8,Henry Anderson,22,henry.anderson@university.edu,3.56");
        } catch (IOException e) {
            System.err.println("Error creating sample CSV: " + e.getMessage());
        }
    }
    
    private static List<Student> convertCSVToObjects() {
        List<Student> students = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("students.csv"))) {
            String line = reader.readLine(); // Skip header
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                
                if (parts.length == 5) {
                    try {
                        Student student = new Student(
                            Integer.parseInt(parts[0].trim()),
                            parts[1].trim(),
                            Integer.parseInt(parts[2].trim()),
                            parts[3].trim(),
                            Double.parseDouble(parts[4].trim())
                        );
                        students.add(student);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing line: " + line + " - " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        
        return students;
    }
    
    private static void displayStudents(List<Student> students) {
        System.out.println("Converted Students from CSV:");
        System.out.println("Total students: " + students.size());
        System.out.println();
        
        for (Student student : students) {
            System.out.println(student);
        }
        
        // Additional analysis
        System.out.println("\nAnalysis:");
        double averageGPA = students.stream()
                                  .mapToDouble(Student::getGpa)
                                  .average()
                                  .orElse(0.0);
        System.out.printf("Average GPA: %.2f%n", averageGPA);
        
        Student topStudent = students.stream()
                                   .max(Comparator.comparing(Student::getGpa))
                                   .orElse(null);
        if (topStudent != null) {
            System.out.println("Top student: " + topStudent.getName() + " (GPA: " + topStudent.getGpa() + ")");
        }
    }
}