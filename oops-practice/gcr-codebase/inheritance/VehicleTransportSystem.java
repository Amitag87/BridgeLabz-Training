public class VehicleTransportSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car(180, "Petrol", 5),
            new Truck(120, "Diesel", 15.5),
            new Motorcycle(200, "Petrol", "V-Twin")
        };
        
        System.out.println("Vehicle Transport System");
        System.out.println("========================");
        
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            System.out.println();
        }
    }
}