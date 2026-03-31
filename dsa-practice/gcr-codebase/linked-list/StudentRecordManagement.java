class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;
    
    public StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManagement {
    private StudentNode head;
    
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }
    
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) return;
        
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        
        StudentNode current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
        }
    }
    
    public StudentNode searchByRollNumber(int rollNumber) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    public void updateGrade(int rollNumber, String newGrade) {
        StudentNode student = searchByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Grade updated for Roll Number " + rollNumber);
        } else {
            System.out.println("Student not found");
        }
    }
    
    public void displayAll() {
        StudentNode current = head;
        System.out.println("=== Student Records ===");
        while (current != null) {
            System.out.println("Roll: " + current.rollNumber + ", Name: " + current.name + 
                             ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
    
    public static void main(String[] args) {
        StudentRecordManagement srm = new StudentRecordManagement();
        
        srm.addAtEnd(101, "Alice", 20, "A");
        srm.addAtEnd(102, "Bob", 21, "B");
        srm.addAtBeginning(100, "Charlie", 19, "A+");
        
        srm.displayAll();
        
        srm.updateGrade(102, "A");
        srm.deleteByRollNumber(100);
        
        System.out.println("\nAfter updates:");
        srm.displayAll();
    }
}