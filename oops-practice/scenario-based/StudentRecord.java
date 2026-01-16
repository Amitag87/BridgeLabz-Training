public class StudentRecord {
    private String name;
    private String[] subjects;
    private int[] marks;
    
    public StudentRecord(String name, String[] subjects, int[] marks) throws InvalidMarkException {
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException("Marks must be between 0-100");
            }
        }
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
    }
    
    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }
    
    public String getGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "A+";
        else if (avg >= 80) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 60) return "C";
        else return "F";
    }
    
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== REPORT CARD ===\n");
        report.append("Student: ").append(name).append("\n");
        report.append("-------------------\n");
        
        for (int i = 0; i < subjects.length; i++) {
            report.append(String.format("%-15s: %3d\n", subjects[i], marks[i]));
        }
        
        report.append("-------------------\n");
        report.append(String.format("Average: %.2f\n", calculateAverage()));
        report.append("Grade: ").append(getGrade()).append("\n");
        
        return report.toString();
    }
    
    public String getName() { return name; }
}