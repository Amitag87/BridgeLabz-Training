import java.util.ArrayList;
import java.util.List;

public class HospitalManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        
        InPatient inPatient = new InPatient("IP001", "John Doe", 45, 5);
        inPatient.addRecord("Admitted for surgery");
        inPatient.addRecord("Post-op recovery");
        
        OutPatient outPatient = new OutPatient("OP001", "Jane Smith", 30);
        outPatient.addRecord("Regular checkup");
        
        patients.add(inPatient);
        patients.add(outPatient);
        
        System.out.println("=== Hospital Patient Management ===");
        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetails());
            System.out.println("Bill Amount: $" + patient.calculateBill());
            
            if (patient instanceof MedicalRecord) {
                MedicalRecord record = (MedicalRecord) patient;
                System.out.println("Medical Records: " + record.viewRecords());
            }
            System.out.println();
        }
    }
}