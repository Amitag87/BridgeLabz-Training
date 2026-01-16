// Demo class for vehicle hybrid inheritance
public class VehicleManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Vehicle Management (Hybrid Inheritance) ===");
        
        // ElectricVehicle only extends Vehicle
        ElectricVehicle tesla = new ElectricVehicle(250, "Tesla Model S", 100);
        
        // PetrolVehicle extends Vehicle and implements Refuelable
        PetrolVehicle bmw = new PetrolVehicle(200, "BMW X5", 80);
        
        System.out.println("Electric Vehicle:");
        tesla.displayInfo();
        tesla.charge();
        System.out.println();
        
        System.out.println("Petrol Vehicle:");
        bmw.displayInfo();
        bmw.refuel();
        System.out.println();
        
        // Demonstrating interface polymorphism
        System.out.println("Refueling all refuelable vehicles:");
        Refuelable[] refuelableVehicles = {bmw}; // Only petrol vehicles can refuel
        for (Refuelable vehicle : refuelableVehicles) {
            vehicle.refuel();
        }
    }
}