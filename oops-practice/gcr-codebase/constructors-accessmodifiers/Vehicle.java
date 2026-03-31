public class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 100.0;
    
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    
    public void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName + ", Vehicle: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }
    
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("John", "Car");
        Vehicle v2 = new Vehicle("Alice", "Bike");
        
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
        
        Vehicle.updateRegistrationFee(150.0);
        System.out.println("After fee update:");
        v1.displayVehicleDetails();
    }
}