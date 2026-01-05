public class Bike extends Vehicle {
    
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days * 0.8; // 20% discount for bikes
    }
}