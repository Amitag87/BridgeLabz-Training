import java.util.ArrayList;
import java.util.List;

public class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double roomChargePerDay = 100.0;
    private List<String> medicalRecords = new ArrayList<>();
    
    public InPatient(String patientId, String name, int age, int daysAdmitted) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
    }
    
    @Override
    public double calculateBill() {
        return daysAdmitted * roomChargePerDay + 500; // Base treatment cost
    }
    
    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }
    
    @Override
    public String viewRecords() {
        return String.join(", ", medicalRecords);
    }
    
    public int getDaysAdmitted() { return daysAdmitted; }
}