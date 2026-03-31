public class RideCar extends RideVehicle implements GPS {
    private String currentLocation = "Unknown";
    
    public RideCar(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm + 5.0; // Base fare $5
    }
    
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}