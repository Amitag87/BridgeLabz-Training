import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("CAR001", 50));
        vehicles.add(new Bike("BIKE001", 20));
        vehicles.add(new Truck("TRUCK001", 100));
        
        int rentalDays = 3;
        
        System.out.println("=== Vehicle Rental System ===");
        for (Vehicle vehicle : vehicles) {
            System.out.println("Vehicle: " + vehicle.getType() + " (" + vehicle.getVehicleNumber() + ")");
            System.out.println("Rental Cost for " + rentalDays + " days: $" + vehicle.calculateRentalCost(rentalDays));
            
            if (vehicle instanceof Insurable) {
                Insurable insurable = (Insurable) vehicle;
                System.out.println("Insurance: $" + insurable.calculateInsurance());
                System.out.println("Details: " + insurable.getInsuranceDetails());
            }
            System.out.println();
        }
    }
}