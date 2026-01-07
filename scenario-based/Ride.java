import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ride {
    private int rideId;
    private User user;
    private Driver driver;
    private String pickupLocation;
    private String dropLocation;
    private double distance;
    private double fare;
    private String fareType;
    private LocalDateTime bookingTime;
    private String status;
    
    public Ride(int rideId, User user, Driver driver, String pickupLocation, 
                String dropLocation, double distance, double fare, String fareType) {
        this.rideId = rideId;
        this.user = user;
        this.driver = driver;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.distance = distance;
        this.fare = fare;
        this.fareType = fareType;
        this.bookingTime = LocalDateTime.now();
        this.status = "Booked";
    }
    
    // Getters
    public int getRideId() { return rideId; }
    public User getUser() { return user; }
    public Driver getDriver() { return driver; }
    public String getPickupLocation() { return pickupLocation; }
    public String getDropLocation() { return dropLocation; }
    public double getDistance() { return distance; }
    public double getFare() { return fare; }
    public String getFareType() { return fareType; }
    public LocalDateTime getBookingTime() { return bookingTime; }
    public String getStatus() { return status; }
    
    public void setStatus(String status) { this.status = status; }
    
    public void displayRide() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("=== RIDE DETAILS ===");
        System.out.println("Ride ID: " + rideId);
        System.out.println("User: " + user.getUserName());
        System.out.println("Driver: " + driver.getDriverName() + " (" + driver.getVehicleNumber() + ")");
        System.out.println("Route: " + pickupLocation + " → " + dropLocation);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Fare: ₹" + String.format("%.2f", fare) + " (" + fareType + ")");
        System.out.println("Booking Time: " + bookingTime.format(formatter));
        System.out.println("Status: " + status);
        System.out.println("==================");
    }
}