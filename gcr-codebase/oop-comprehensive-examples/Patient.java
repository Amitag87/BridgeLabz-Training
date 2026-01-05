public abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;
    
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    
    public abstract double calculateBill();
    
    public String getPatientDetails() {
        return "ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
    
    // Getters and Setters
    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDiagnosis() { return diagnosis; }
    protected void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
}