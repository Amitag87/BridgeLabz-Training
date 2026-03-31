public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient patient1 = new Patient("John Doe", 30, "Flu");
        Bill bill = new Bill(patient1, 1500.00);
        InPatient inpatient = new InPatient("Jane Smith", 45, "Surgery", "A101", 5);
        OutPatient outpatient = new OutPatient("Ram", 20, "Typhoid", "22-10-1014");
        bill.getPatient().getName();
    }
}
interface Payable{
    void printBill();
}

class Patient{
    
    private String name;
    private int age;
    private String disease;
    public Patient(String name,int age, String disease){
        this.name=name;
        this.age=age;
        this.disease=disease;
    }
    public String getName(){
        return name;
    }
    public int age(){
        return age;
    }
    public static void displayinfo(Patient patient){
        System.out.println("Patient Name: "+patient.getName());
        System.out.println("Patient Age: "+patient.age());
        System.out.println("Disease: "+patient.disease);
    }
}
class Doctor{
    private String name;
    private String specialization;
    public Doctor(String name, String specialization){
        this.name=name;
        this.specialization=specialization;
    }
    public String getName(){
        return name;
    }
    public String getSpecialization(){
        return specialization;
    }
    public static void displayinfo(Doctor doctor){
        System.out.println("Doctor Name: "+doctor.getName());
        System.out.println("Specialization: "+doctor.getSpecialization());
    }
}
class Bill implements Payable{
    private Patient patient;
    private double amount;
    public Bill(Patient patient, double amount){
        this.patient=patient;
        this.amount=amount;
    }
    public Patient getPatient(){
        return patient;
    }
    public double getAmount(){
        return amount;
    }
    public static void displayinfo(Bill bill){
        System.out.println("Patient: "+bill.getPatient().getName());
        System.out.println("Amount: "+bill.getAmount());
    }
    public void printBill(){
        System.out.println("Patient: "+patient.getName());
        System.out.println("Amount: "+amount);
    }
}
 class InPatient extends Patient{
    private String roomNumber;
    private int daysAdmitted;
    public InPatient(String name, int age, String disease, String roomNumber, int daysAdmitted){
        super(name, age, disease);
        this.roomNumber=roomNumber;
        this.daysAdmitted=daysAdmitted;
    }
    
    public String getRoomNumber(){
        return roomNumber;
    }
    
    public int getDaysAdmitted(){
        return daysAdmitted;
    }
    public static void displayinfo(String roomNumber, int daysAdmitted, InPatient inpatient){
        // Patient.displayinfo();
        System.out.println("Room Number: "+inpatient.getRoomNumber());
        System.out.println("Days Admitted: "+inpatient.getDaysAdmitted());
    }
 }
 class OutPatient extends Patient{
    private String appointmentDate;
    public OutPatient(String name, int age, String disease, String appointmentDate){
        super(name, age, disease);
        this.appointmentDate=appointmentDate;
    }
    
    public String getAppointmentDate(){
        return appointmentDate;
    }
 } 