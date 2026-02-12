import java.util.*;

class NoParkingSlotAvailableException extends Exception {
    public NoParkingSlotAvailableException(String message) {
        super(message);
    }
}

abstract class Vehicle {
    protected String vehicleNumber;
    protected String ownerName;
    
    public Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }
    
    public String getVehicleNumber() { return vehicleNumber; }
    public String getOwnerName() { return ownerName; }
    public abstract String getType();
}

class Car extends Vehicle {
    public Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }
    
    @Override
    public String getType() { return "Car"; }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }
    
    @Override
    public String getType() { return "Bike"; }
}

class ParkingSlot {
    private int slotNumber;
    private String slotType;
    private boolean isOccupied;
    private Vehicle parkedVehicle;
    
    public ParkingSlot(int slotNumber, String slotType) {
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        this.isOccupied = false;
    }
    
    public int getSlotNumber() { return slotNumber; }
    public String getSlotType() { return slotType; }
    public boolean isOccupied() { return isOccupied; }
    public Vehicle getParkedVehicle() { return parkedVehicle; }
    
    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
    }
    
    public void vacate() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }
}

class ParkingSystem {
    private Map<Integer, ParkingSlot> slots;
    private Queue<Vehicle> waitingQueue;
    
    public ParkingSystem() {
        slots = new TreeMap<>();
        waitingQueue = new LinkedList<>();
    }
    
    public void addSlot(int slotNumber, String slotType) {
        slots.put(slotNumber, new ParkingSlot(slotNumber, slotType));
    }
    
    public void allocateSlot(Vehicle vehicle) throws NoParkingSlotAvailableException {
        String requiredType = vehicle.getType();
        
        for (Map.Entry<Integer, ParkingSlot> entry : slots.entrySet()) {
            ParkingSlot slot = entry.getValue();
            if (!slot.isOccupied() && slot.getSlotType().equals(requiredType)) {
                slot.parkVehicle(vehicle);
                System.out.println(vehicle.getType() + " " + vehicle.getVehicleNumber() + 
                                 " allocated to slot " + slot.getSlotNumber());
                return;
            }
        }
        
        waitingQueue.add(vehicle);
        throw new NoParkingSlotAvailableException("No parking slot available for " + 
                                                  vehicle.getType() + " " + vehicle.getVehicleNumber() + 
                                                  ". Added to waiting queue.");
    }
    
    public void vacateSlot(int slotNumber) {
        ParkingSlot slot = slots.get(slotNumber);
        if (slot != null && slot.isOccupied()) {
            Vehicle vehicle = slot.getParkedVehicle();
            System.out.println("Slot " + slotNumber + " vacated by " + vehicle.getType() + 
                             " " + vehicle.getVehicleNumber());
            slot.vacate();
            
            if (!waitingQueue.isEmpty()) {
                Vehicle waiting = waitingQueue.poll();
                try {
                    allocateSlot(waiting);
                } catch (NoParkingSlotAvailableException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    
    public void displayStatus() {
        System.out.println("\n=== Parking Status ===");
        for (Map.Entry<Integer, ParkingSlot> entry : slots.entrySet()) {
            ParkingSlot slot = entry.getValue();
            if (slot.isOccupied()) {
                System.out.println("Slot " + slot.getSlotNumber() + " (" + slot.getSlotType() + 
                                 "): " + slot.getParkedVehicle().getVehicleNumber());
            } else {
                System.out.println("Slot " + slot.getSlotNumber() + " (" + slot.getSlotType() + "): Empty");
            }
        }
        System.out.println("Waiting Queue: " + waitingQueue.size() + " vehicles");
    }
}

public class SmartParkingSlotAllocation {
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem();
        
        parkingSystem.addSlot(1, "Car");
        parkingSystem.addSlot(2, "Car");
        parkingSystem.addSlot(3, "Bike");
        parkingSystem.addSlot(4, "Bike");
        parkingSystem.addSlot(5, "Car");
        
        System.out.println("=== Smart Parking System ===\n");
        
        try {
            parkingSystem.allocateSlot(new Car("KA01AB1234", "John"));
            parkingSystem.allocateSlot(new Car("KA02CD5678", "Alice"));
            parkingSystem.allocateSlot(new Bike("KA03EF9012", "Bob"));
            parkingSystem.allocateSlot(new Car("KA04GH3456", "Sarah"));
        } catch (NoParkingSlotAvailableException e) {
            System.out.println(e.getMessage());
        }
        
        parkingSystem.displayStatus();
        
        System.out.println("\n=== Vacating Slot 1 ===");
        parkingSystem.vacateSlot(1);
        
        try {
            parkingSystem.allocateSlot(new Car("KA05IJ7890", "Mike"));
            parkingSystem.allocateSlot(new Car("KA06KL1122", "Emma"));
        } catch (NoParkingSlotAvailableException e) {
            System.out.println(e.getMessage());
        }
        
        parkingSystem.displayStatus();
    }
}