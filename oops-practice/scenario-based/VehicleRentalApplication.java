import java.util.ArrayList;
import java.util.List;

abstract class Vehicle implements IRentable {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected double dailyRate;
    protected boolean isAvailable;
    
    public Vehicle(String vehicleId, String brand, String model, double dailyRate) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
        this.isAvailable = true;
    }
    
    public String getVehicleId() { return vehicleId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
    
    public abstract String getVehicleType();
}

class Car extends Vehicle {
    private int seatingCapacity;
    
    public Car(String vehicleId, String brand, String model, double dailyRate, int seatingCapacity) {
        super(vehicleId, brand, model, dailyRate);
        this.seatingCapacity = seatingCapacity;
    }
    
    @Override
    public double calculateRent(int days) {
        return dailyRate * days;
    }
    
    @Override
    public String getVehicleType() {
        return "Car";
    }
    
    public int getSeatingCapacity() { return seatingCapacity; }
}

class Bike extends Vehicle {
    private String engineType;
    
    public Bike(String vehicleId, String brand, String model, double dailyRate, String engineType) {
        super(vehicleId, brand, model, dailyRate);
        this.engineType = engineType;
    }
    
    @Override
    public double calculateRent(int days) {
        return dailyRate * days * 0.8; // 20% discount for bikes
    }
    
    @Override
    public String getVehicleType() {
        return "Bike";
    }
    
    public String getEngineType() { return engineType; }
}

class Truck extends Vehicle {
    private double loadCapacity;
    
    public Truck(String vehicleId, String brand, String model, double dailyRate, double loadCapacity) {
        super(vehicleId, brand, model, dailyRate);
        this.loadCapacity = loadCapacity;
    }
    
    @Override
    public double calculateRent(int days) {
        return dailyRate * days * 1.5; // 50% premium for trucks
    }
    
    @Override
    public String getVehicleType() {
        return "Truck";
    }
    
    public double getLoadCapacity() { return loadCapacity; }
}

class Customer {
    private String customerId;
    private String name;
    private String phoneNumber;
    
    public Customer(String customerId, String name, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
}

class Rental {
    private String rentalId;
    private Customer customer;
    private Vehicle vehicle;
    private int days;
    private double totalCost;
    
    public Rental(String rentalId, Customer customer, Vehicle vehicle, int days) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
        this.totalCost = vehicle.calculateRent(days);
    }
    
    public String getRentalId() { return rentalId; }
    public Customer getCustomer() { return customer; }
    public Vehicle getVehicle() { return vehicle; }
    public int getDays() { return days; }
    public double getTotalCost() { return totalCost; }
}

public class VehicleRentalApplication {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();
    private int rentalCounter = 1;
    
    // CREATE operations
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added: " + vehicle.getVehicleType() + " - " + vehicle.getBrand());
    }
    
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added: " + customer.getName());
    }
    
    public Rental rentVehicle(String customerId, String vehicleId, int days) {
        Customer customer = findCustomer(customerId);
        Vehicle vehicle = findVehicle(vehicleId);
        
        if (customer == null) {
            System.out.println("Customer not found");
            return null;
        }
        
        if (vehicle == null || !vehicle.isAvailable()) {
            System.out.println("Vehicle not available");
            return null;
        }
        
        vehicle.setAvailable(false);
        Rental rental = new Rental("R" + rentalCounter++, customer, vehicle, days);
        rentals.add(rental);
        
        System.out.println("Vehicle rented successfully. Total cost: $" + rental.getTotalCost());
        return rental;
    }
    
    // READ operations
    public Vehicle findVehicle(String vehicleId) {
        return vehicles.stream()
                .filter(v -> v.getVehicleId().equals(vehicleId))
                .findFirst()
                .orElse(null);
    }
    
    public Customer findCustomer(String customerId) {
        return customers.stream()
                .filter(c -> c.getCustomerId().equals(customerId))
                .findFirst()
                .orElse(null);
    }
    
    public void displayAvailableVehicles() {
        System.out.println("=== Available Vehicles ===");
        vehicles.stream()
                .filter(Vehicle::isAvailable)
                .forEach(v -> System.out.println(v.getVehicleId() + " - " + v.getVehicleType() + 
                                               " " + v.getBrand() + " " + v.getModel() + 
                                               " ($" + v.dailyRate + "/day)"));
    }
    
    public void displayRentals() {
        System.out.println("=== Active Rentals ===");
        rentals.forEach(r -> System.out.println("Rental ID: " + r.getRentalId() + 
                                               ", Customer: " + r.getCustomer().getName() + 
                                               ", Vehicle: " + r.getVehicle().getBrand() + 
                                               ", Days: " + r.getDays() + 
                                               ", Cost: $" + r.getTotalCost()));
    }
    
    // UPDATE operation
    public void returnVehicle(String rentalId) {
        Rental rental = rentals.stream()
                .filter(r -> r.getRentalId().equals(rentalId))
                .findFirst()
                .orElse(null);
        
        if (rental != null) {
            rental.getVehicle().setAvailable(true);
            System.out.println("Vehicle returned successfully");
        } else {
            System.out.println("Rental not found");
        }
    }
    
    // DELETE operation
    public void removeVehicle(String vehicleId) {
        vehicles.removeIf(v -> v.getVehicleId().equals(vehicleId));
        System.out.println("Vehicle removed");
    }
    
    public static void main(String[] args) {
        VehicleRentalApplication app = new VehicleRentalApplication();
        
        // Add vehicles
        app.addVehicle(new Car("C001", "Toyota", "Camry", 50.0, 5));
        app.addVehicle(new Bike("B001", "Honda", "CBR", 20.0, "Sport"));
        app.addVehicle(new Truck("T001", "Ford", "F-150", 80.0, 2.5));
        
        // Add customers
        app.addCustomer(new Customer("CU001", "John Doe", "9876543210"));
        app.addCustomer(new Customer("CU002", "Jane Smith", "8765432109"));
        
        // Display available vehicles
        app.displayAvailableVehicles();
        
        // Rent vehicles
        app.rentVehicle("CU001", "C001", 3);
        app.rentVehicle("CU002", "B001", 2);
        
        // Display rentals
        app.displayRentals();
        
        // Return vehicle
        app.returnVehicle("R1");
        
        // Display available vehicles after return
        System.out.println("\\nAfter return:");
        app.displayAvailableVehicles();
    }
}