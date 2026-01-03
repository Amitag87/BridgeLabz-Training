// PetrolVehicle extends Vehicle and implements Refuelable (Hybrid Inheritance)
public class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelCapacity;
    
    public PetrolVehicle(int maxSpeed, String model, int fuelCapacity) {
        super(maxSpeed, model);
        this.fuelCapacity = fuelCapacity;
    }
    
    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Fuel capacity: " + fuelCapacity + " liters");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
}