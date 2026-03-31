import java.io.*;

public class DataStreams {
    public static void main(String[] args) {
        String filename = "students.dat";
        
        // Write student data
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            // Student 1
            dos.writeInt(101);
            dos.writeUTF("John Doe");
            dos.writeDouble(3.8);
            
            // Student 2
            dos.writeInt(102);
            dos.writeUTF("Jane Smith");
            dos.writeDouble(3.9);
            
            // Student 3
            dos.writeInt(103);
            dos.writeUTF("Bob Johnson");
            dos.writeDouble(3.7);
            
            System.out.println("Student data written to file");
            
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
        
        // Read student data
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            System.out.println("\nReading student data:");
            
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                
                System.out.println("Roll: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
            
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}