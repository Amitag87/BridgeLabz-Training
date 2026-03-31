public class Truck extends Vehicle {
    private double loadCapacity;
    
    public Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Truck - Max Speed: " + maxSpeed + " km/h, Fuel Type: " + fuelType);
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}