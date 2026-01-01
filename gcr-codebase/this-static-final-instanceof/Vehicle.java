public class Vehicle {
    private static double registrationFee = 150.0;
    
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;
    
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    
    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }
    
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Honest raj", "Sedan", "ABC123");
        Vehicle vehicle2 = new Vehicle("Price danish", "SUV", "XYZ789");
        
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}