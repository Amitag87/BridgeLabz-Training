import java.util.ArrayList;
import java.util.List;

public class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee = 50.0;
    private List<String> medicalRecords = new ArrayList<>();
    
    public OutPatient(String patientId, String name, int age) {
        super(patientId, name, age);
    }
    
    @Override
    public double calculateBill() {
        return consultationFee;
    }
    
    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }
    
    @Override
    public String viewRecords() {
        return String.join(", ", medicalRecords);
    }
}