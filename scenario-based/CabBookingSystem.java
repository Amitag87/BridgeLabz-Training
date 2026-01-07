import java.util.*;

public class CabBookingSystem {
    private List<User> users;
    private List<Driver> drivers;
    private List<Ride> rideHistory;
    private int nextRideId;
    
    public CabBookingSystem() {
        this.users = new ArrayList<>();
        this.drivers = new ArrayList<>();
        this.rideHistory = new ArrayList<>();
        this.nextRideId = 1001;
        initializeData();
    }
    
    private void initializeData() {
        // Add sample users
        users.add(new User(1, "Amit Kumar", "9876543210"));
        users.add(new User(2, "Priya Sharma", "8765432109"));
        users.add(new User(3, "Rahul Singh", "7654321098"));
        
        // Add sample drivers
        drivers.add(new Driver(101, "Ravi Verma", "DL-01-AB-1234"));
        drivers.add(new Driver(102, "Suresh Gupta", "DL-02-CD-5678"));
        drivers.add(new Driver(103, "Manoj Yadav", "DL-03-EF-9012"));
        drivers.add(new Driver(104, "Vikash Kumar", "DL-04-GH-3456"));
    }
    
    // CREATE - Book a new ride
    public Ride bookRide(int userId, String pickup, String drop, double distance, 
                        FareCalculator fareCalculator) throws NoDriverAvailableException {
        
        User user = findUserById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
        
        Driver availableDriver = findAvailableDriver();
        if (availableDriver == null) {
            throw new NoDriverAvailableException("No drivers available at the moment. Please try again later.");
        }
        
        double fare = fareCalculator.calculateFare(distance);
        
        Ride ride = new Ride(nextRideId++, user, availableDriver, pickup, drop, 
                           distance, fare, fareCalculator.getFareType());
        
        availableDriver.setAvailable(false);
        rideHistory.add(ride);
        
        System.out.println("✅ Ride booked successfully!");
        return ride;
    }
    
    // READ - Get ride by ID
    public Ride getRideById(int rideId) {
        return rideHistory.stream()
                .filter(ride -> ride.getRideId() == rideId)
                .findFirst()
                .orElse(null);
    }
    
    // READ - Get all rides for a user
    public List<Ride> getUserRideHistory(int userId) {
        return rideHistory.stream()
                .filter(ride -> ride.getUser().getUserId() == userId)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    // UPDATE - Complete a ride
    public void completeRide(int rideId) {
        Ride ride = getRideById(rideId);
        if (ride != null) {
            ride.setStatus("Completed");
            ride.getDriver().setAvailable(true);
            System.out.println("✅ Ride completed successfully!");
        } else {
            System.out.println("❌ Ride not found with ID: " + rideId);
        }
    }
    
    // UPDATE - Cancel a ride
    public void cancelRide(int rideId) {
        Ride ride = getRideById(rideId);
        if (ride != null && !ride.getStatus().equals("Completed")) {
            ride.setStatus("Cancelled");
            ride.getDriver().setAvailable(true);
            System.out.println("✅ Ride cancelled successfully!");
        } else {
            System.out.println("❌ Cannot cancel ride. Either ride not found or already completed.");
        }
    }
    
    // DELETE - Remove ride from history (admin function)
    public void deleteRide(int rideId) {
        rideHistory.removeIf(ride -> ride.getRideId() == rideId);
        System.out.println("✅ Ride deleted from history!");
    }
    
    // Utility methods
    private User findUserById(int userId) {
        return users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }
    
    private Driver findAvailableDriver() {
        return drivers.stream()
                .filter(Driver::isAvailable)
                .findFirst()
                .orElse(null);
    }
    
    public void displayAllRides() {
        System.out.println("\n=== ALL RIDE HISTORY ===");
        if (rideHistory.isEmpty()) {
            System.out.println("No rides found.");
            return;
        }
        
        for (Ride ride : rideHistory) {
            ride.displayRide();
        }
    }
    
    public void displayAvailableDrivers() {
        System.out.println("\n=== AVAILABLE DRIVERS ===");
        drivers.stream()
                .filter(Driver::isAvailable)
                .forEach(System.out::println);
    }
    
    public void displayUsers() {
        System.out.println("\n=== REGISTERED USERS ===");
        users.forEach(System.out::println);
    }
    
    // Main method with demo
    public static void main(String[] args) {
        CabBookingSystem system = new CabBookingSystem();
        
        // Create fare calculators
        FareCalculator normalFare = new NormalFare();
        FareCalculator peakFare = new PeakFare();
        
        System.out.println("🚗 Welcome to Cab Booking System 🚗\n");
        
        try {
            // Demo: Book rides
            System.out.println("📱 Booking rides...\n");
            
            Ride ride1 = system.bookRide(1, "Connaught Place", "Airport", 25.0, normalFare);
            ride1.displayRide();
            
            Ride ride2 = system.bookRide(2, "Gurgaon", "Noida", 35.0, peakFare);
            ride2.displayRide();
            
            Ride ride3 = system.bookRide(3, "Karol Bagh", "India Gate", 15.0, normalFare);
            ride3.displayRide();
            
            // Try to book when no drivers available
            Ride ride4 = system.bookRide(1, "Dwarka", "Lajpat Nagar", 20.0, normalFare);
            ride4.displayRide();
            
        } catch (NoDriverAvailableException e) {
            System.out.println("❌ " + e.getMessage());
        }
        
        // Display available drivers
        system.displayAvailableDrivers();
        
        // Complete a ride
        System.out.println("\n🏁 Completing ride...");
        system.completeRide(1001);
        
        // Display ride history for a user
        System.out.println("\n📋 User ride history:");
        List<Ride> userRides = system.getUserRideHistory(1);
        userRides.forEach(Ride::displayRide);
        
        // Cancel a ride
        System.out.println("\n❌ Cancelling ride...");
        system.cancelRide(1002);
        
        // Display all rides
        system.displayAllRides();
        
        // Display available drivers after operations
        system.displayAvailableDrivers();
    }
}