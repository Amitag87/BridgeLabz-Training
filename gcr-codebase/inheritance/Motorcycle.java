public class Motorcycle extends Vehicle {
    private String engineType;
    
    public Motorcycle(int maxSpeed, String fuelType, String engineType) {
        super(maxSpeed, fuelType);
        this.engineType = engineType;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Motorcycle - Max Speed: " + maxSpeed + " km/h, Fuel Type: " + fuelType);
        System.out.println("Engine Type: " + engineType);
    }
}