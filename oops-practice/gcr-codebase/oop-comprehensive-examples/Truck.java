public class Truck extends Vehicle implements Insurable {
    private String policyNumber;
    
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = "POL" + vehicleNumber;
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days * 1.5; // 50% premium for trucks
    }
    
    @Override
    public double calculateInsurance() {
        return rentalRate * 0.25; // 25% of rental rate
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance - Policy: " + policyNumber;
    }
}