import java.util.ArrayList;
import java.util.List;

public class RideHailingApp {
    public static void calculateFares(List<RideVehicle> vehicles, double distance) {
        System.out.println("=== Ride-Hailing Application ===");
        System.out.println("Distance: " + distance + " km");
        System.out.println();
        
        for (RideVehicle vehicle : vehicles) {
            System.out.println(vehicle.getVehicleDetails());
            System.out.println("Fare: $" + vehicle.calculateFare(distance));
            
            if (vehicle instanceof GPS) {
                GPS gps = (GPS) vehicle;
                gps.updateLocation("Downtown");
                System.out.println("Current Location: " + gps.getCurrentLocation());
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        List<RideVehicle> vehicles = new ArrayList<>();
        vehicles.add(new RideCar("CAR001", "John Driver", 2.0));
        vehicles.add(new RideBike("BIKE001", "Mike Rider", 1.0));
        vehicles.add(new RideAuto("AUTO001", "Sam Auto", 1.5));
        
        calculateFares(vehicles, 10.0);
    }
}