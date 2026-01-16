public abstract class RideVehicle {
    private String vehicleId;
    private String driverName;
    protected double ratePerKm;
    
    public RideVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    
    public abstract double calculateFare(double distance);
    
    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate: $" + ratePerKm + "/km";
    }
    
    // Getters and Setters
    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }
}