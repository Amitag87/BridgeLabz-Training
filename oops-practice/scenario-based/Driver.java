public class Driver {
    private int driverId;
    private String driverName;
    private String vehicleNumber;
    private boolean isAvailable;
    private double rating;
    
    public Driver(int driverId, String driverName, String vehicleNumber) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehicleNumber = vehicleNumber;
        this.isAvailable = true;
        this.rating = 4.5; // Default rating
    }
    
    // Getters and Setters
    public int getDriverId() { return driverId; }
    public String getDriverName() { return driverName; }
    public String getVehicleNumber() { return vehicleNumber; }
    public boolean isAvailable() { return isAvailable; }
    public double getRating() { return rating; }
    
    public void setAvailable(boolean available) { this.isAvailable = available; }
    public void setRating(double rating) { this.rating = rating; }
    
    @Override
    public String toString() {
        return "Driver{ID=" + driverId + ", Name='" + driverName + 
               "', Vehicle='" + vehicleNumber + "', Available=" + isAvailable + 
               ", Rating=" + rating + "}";
    }
}