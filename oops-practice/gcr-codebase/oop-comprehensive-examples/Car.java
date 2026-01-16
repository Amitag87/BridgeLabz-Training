public class Car extends Vehicle implements Insurable {
    private String policyNumber;
    
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = "POL" + vehicleNumber;
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }
    
    @Override
    public double calculateInsurance() {
        return rentalRate * 0.15; // 15% of rental rate
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Car Insurance - Policy: " + policyNumber;
    }
}