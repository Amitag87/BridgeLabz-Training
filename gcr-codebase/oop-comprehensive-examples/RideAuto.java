public class RideAuto extends RideVehicle implements GPS {
    private String currentLocation = "Unknown";
    
    public RideAuto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm + 2.0; // Base fare $2
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