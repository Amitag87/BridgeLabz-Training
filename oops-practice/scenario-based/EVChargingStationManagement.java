import java.util.*;

class NoChargingSlotAvailableException extends Exception {
    public NoChargingSlotAvailableException(String message) {
        super(message);
    }
}

interface PricingStrategy {
    double calculatePrice(double units);
    String getPricingType();
}

class RegularPricing implements PricingStrategy {
    private static final double RATE_PER_UNIT = 8.0;
    
    @Override
    public double calculatePrice(double units) {
        return units * RATE_PER_UNIT;
    }
    
    @Override
    public String getPricingType() {
        return "Regular";
    }
}

class PeakHourPricing implements PricingStrategy {
    private static final double RATE_PER_UNIT = 12.0;
    
    @Override
    public double calculatePrice(double units) {
        return units * RATE_PER_UNIT;
    }
    
    @Override
    public String getPricingType() {
        return "Peak Hour";
    }
}

class Vehicle {
    private String vehicleNumber;
    private String ownerName;
    private String vehicleType;
    
    public Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    
    public String getVehicleNumber() { return vehicleNumber; }
    public String getOwnerName() { return ownerName; }
    public String getVehicleType() { return vehicleType; }
    
    @Override
    public String toString() {
        return vehicleType + " " + vehicleNumber + " (" + ownerName + ")";
    }
}

class ChargingSlot {
    private int slotId;
    private boolean isOccupied;
    private Vehicle currentVehicle;
    private double unitsConsumed;
    private PricingStrategy pricingStrategy;
    
    public ChargingSlot(int slotId) {
        this.slotId = slotId;
        this.isOccupied = false;
    }
    
    public int getSlotId() { return slotId; }
    public boolean isOccupied() { return isOccupied; }
    public Vehicle getCurrentVehicle() { return currentVehicle; }
    
    public void assignVehicle(Vehicle vehicle, PricingStrategy strategy) {
        this.currentVehicle = vehicle;
        this.pricingStrategy = strategy;
        this.isOccupied = true;
        this.unitsConsumed = 0;
    }
    
    public double completeCharging(double units) {
        this.unitsConsumed = units;
        double bill = pricingStrategy.calculatePrice(units);
        return bill;
    }
    
    public void releaseSlot() {
        this.currentVehicle = null;
        this.pricingStrategy = null;
        this.isOccupied = false;
        this.unitsConsumed = 0;
    }
    
    public PricingStrategy getPricingStrategy() { return pricingStrategy; }
    public double getUnitsConsumed() { return unitsConsumed; }
}

class ChargingStationManager {
    private Map<Integer, ChargingSlot> chargingSlots;
    private Queue<Vehicle> waitingQueue;
    
    public ChargingStationManager() {
        chargingSlots = new TreeMap<>();
        waitingQueue = new LinkedList<>();
    }
    
    public void addChargingSlot(int slotId) {
        chargingSlots.put(slotId, new ChargingSlot(slotId));
        System.out.println("Charging slot " + slotId + " added");
    }
    
    public void allocateSlot(Vehicle vehicle, PricingStrategy strategy) throws NoChargingSlotAvailableException {
        for (Map.Entry<Integer, ChargingSlot> entry : chargingSlots.entrySet()) {
            ChargingSlot slot = entry.getValue();
            if (!slot.isOccupied()) {
                slot.assignVehicle(vehicle, strategy);
                System.out.println("Slot " + slot.getSlotId() + " allocated to " + vehicle + 
                                 " [" + strategy.getPricingType() + " Pricing]");
                return;
            }
        }
        
        waitingQueue.add(vehicle);
        throw new NoChargingSlotAvailableException("No charging slot available for " + vehicle + 
                                                   ". Added to waiting queue.");
    }
    
    public void completeChargingAndGenerateBill(int slotId, double unitsConsumed) {
        ChargingSlot slot = chargingSlots.get(slotId);
        
        if (slot == null || !slot.isOccupied()) {
            System.out.println("Slot " + slotId + " is not occupied");
            return;
        }
        
        Vehicle vehicle = slot.getCurrentVehicle();
        double bill = slot.completeCharging(unitsConsumed);
        
        System.out.println("\n=== Charging Bill ===");
        System.out.println("Slot: " + slotId);
        System.out.println("Vehicle: " + vehicle);
        System.out.println("Units Consumed: " + unitsConsumed + " kWh");
        System.out.println("Pricing Type: " + slot.getPricingStrategy().getPricingType());
        System.out.printf("Total Bill: Rs.%.2f%n", bill);
        
        slot.releaseSlot();
        System.out.println("Slot " + slotId + " released\n");
        
        if (!waitingQueue.isEmpty()) {
            Vehicle waiting = waitingQueue.poll();
            try {
                allocateSlot(waiting, new RegularPricing());
            } catch (NoChargingSlotAvailableException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void displayStatus() {
        System.out.println("\n=== Charging Station Status ===");
        for (Map.Entry<Integer, ChargingSlot> entry : chargingSlots.entrySet()) {
            ChargingSlot slot = entry.getValue();
            if (slot.isOccupied()) {
                System.out.println("Slot " + slot.getSlotId() + ": " + slot.getCurrentVehicle() + 
                                 " [" + slot.getPricingStrategy().getPricingType() + "]");
            } else {
                System.out.println("Slot " + slot.getSlotId() + ": Available");
            }
        }
        System.out.println("Waiting Queue: " + waitingQueue.size() + " vehicles");
        if (!waitingQueue.isEmpty()) {
            System.out.println("Waiting: " + waitingQueue);
        }
    }
}

public class EVChargingStationManagement {
    public static void main(String[] args) {
        ChargingStationManager manager = new ChargingStationManager();
        
        System.out.println("=== EV Charging Station Management System ===\n");
        
        manager.addChargingSlot(1);
        manager.addChargingSlot(2);
        manager.addChargingSlot(3);
        
        System.out.println("\n=== Allocating Vehicles ===");
        
        try {
            manager.allocateSlot(new Vehicle("KA01EV1234", "John", "Tesla Model 3"), new RegularPricing());
            manager.allocateSlot(new Vehicle("KA02EV5678", "Alice", "Tata Nexon EV"), new PeakHourPricing());
            manager.allocateSlot(new Vehicle("KA03EV9012", "Bob", "MG ZS EV"), new RegularPricing());
            manager.allocateSlot(new Vehicle("KA04EV3456", "Sarah", "Hyundai Kona"), new PeakHourPricing());
        } catch (NoChargingSlotAvailableException e) {
            System.out.println(e.getMessage());
        }
        
        manager.displayStatus();
        
        System.out.println("\n=== Completing Charging Sessions ===");
        manager.completeChargingAndGenerateBill(1, 25.5);
        manager.completeChargingAndGenerateBill(2, 30.0);
        
        manager.displayStatus();
        
        System.out.println("\n=== Adding More Vehicles ===");
        try {
            manager.allocateSlot(new Vehicle("KA05EV7890", "Mike", "BYD Atto 3"), new RegularPricing());
        } catch (NoChargingSlotAvailableException e) {
            System.out.println(e.getMessage());
        }
        
        manager.displayStatus();
    }
}