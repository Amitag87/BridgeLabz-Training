import java.util.*;

// Vehicle class
class Vehicle {
    private String vehicleId;
    private String type;
    private String direction;
    
    public Vehicle(String vehicleId, String type, String direction) {
        this.vehicleId = vehicleId;
        this.type = type;
        this.direction = direction;
    }
    
    public String getVehicleId() { return vehicleId; }
    public String getType() { return type; }
    public String getDirection() { return direction; }
    
    @Override
    public String toString() {
        return vehicleId + "(" + type + "->" + direction + ")";
    }
}

// Node for circular linked list
class VehicleNode {
    Vehicle vehicle;
    VehicleNode next;
    
    public VehicleNode(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.next = null;
    }
}

// Circular Linked List for roundabout
class RoundaboutCircle {
    private VehicleNode head;
    private int size;
    private final int MAX_CAPACITY = 8;
    
    public RoundaboutCircle() {
        this.head = null;
        this.size = 0;
    }
    
    public boolean addVehicle(Vehicle vehicle) {
        if (size >= MAX_CAPACITY) {
            return false; // Roundabout full
        }
        
        VehicleNode newNode = new VehicleNode(vehicle);
        
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            VehicleNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
        
        size++;
        return true;
    }
    
    public Vehicle removeVehicle(String vehicleId) {
        if (head == null) return null;
        
        VehicleNode current = head;
        VehicleNode prev = null;
        
        // Find the last node to get previous of head
        if (size > 1) {
            while (current.next != head) {
                current = current.next;
            }
            prev = current;
            current = head;
        }
        
        // Search for vehicle
        do {
            if (current.vehicle.getVehicleId().equals(vehicleId)) {
                Vehicle removedVehicle = current.vehicle;
                
                if (size == 1) {
                    head = null;
                } else {
                    if (current == head) {
                        head = head.next;
                        prev.next = head;
                    } else {
                        prev.next = current.next;
                    }
                }
                
                size--;
                return removedVehicle;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        
        return null;
    }
    
    public void displayRoundabout() {
        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }
        
        System.out.print("Roundabout: ");
        VehicleNode current = head;
        do {
            System.out.print(current.vehicle + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to " + head.vehicle.getVehicleId() + ")");
    }
    
    public boolean isFull() {
        return size >= MAX_CAPACITY;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int getSize() {
        return size;
    }
}

// Queue for waiting vehicles
class WaitingQueue {
    private Queue<Vehicle> queue;
    private final int MAX_QUEUE_SIZE = 15;
    
    public WaitingQueue() {
        this.queue = new LinkedList<>();
    }
    
    public boolean enqueue(Vehicle vehicle) {
        if (queue.size() >= MAX_QUEUE_SIZE) {
            System.out.println("Queue overflow! Cannot add vehicle: " + vehicle.getVehicleId());
            return false;
        }
        
        queue.offer(vehicle);
        System.out.println("Vehicle " + vehicle.getVehicleId() + " added to waiting queue");
        return true;
    }
    
    public Vehicle dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue underflow! No vehicles waiting");
            return null;
        }
        
        Vehicle vehicle = queue.poll();
        System.out.println("Vehicle " + vehicle.getVehicleId() + " removed from waiting queue");
        return vehicle;
    }
    
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Waiting queue is empty");
            return;
        }
        
        System.out.print("Waiting Queue: ");
        for (Vehicle vehicle : queue) {
            System.out.print(vehicle + " ");
        }
        System.out.println();
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public boolean isFull() {
        return queue.size() >= MAX_QUEUE_SIZE;
    }
    
    public int getSize() {
        return queue.size();
    }
}

public class TrafficManager {
    private RoundaboutCircle roundabout;
    private WaitingQueue waitingQueue;
    private int vehicleCounter = 1;
    
    public TrafficManager() {
        this.roundabout = new RoundaboutCircle();
        this.waitingQueue = new WaitingQueue();
    }
    
    public void addVehicleToSystem(String type, String direction) {
        String vehicleId = "V" + String.format("%03d", vehicleCounter++);
        Vehicle vehicle = new Vehicle(vehicleId, type, direction);
        
        // Try to add directly to roundabout
        if (roundabout.addVehicle(vehicle)) {
            System.out.println("Vehicle " + vehicleId + " entered roundabout directly");
        } else {
            // Add to waiting queue if roundabout is full
            if (waitingQueue.enqueue(vehicle)) {
                System.out.println("Roundabout full, vehicle " + vehicleId + " added to queue");
            } else {
                System.out.println("System full! Vehicle " + vehicleId + " cannot enter");
            }
        }
    }
    
    public void exitVehicle(String vehicleId) {
        Vehicle exitedVehicle = roundabout.removeVehicle(vehicleId);
        
        if (exitedVehicle != null) {
            System.out.println("Vehicle " + vehicleId + " exited roundabout");
            
            // Try to move vehicle from queue to roundabout
            if (!waitingQueue.isEmpty()) {
                Vehicle nextVehicle = waitingQueue.dequeue();
                if (roundabout.addVehicle(nextVehicle)) {
                    System.out.println("Vehicle " + nextVehicle.getVehicleId() + " moved from queue to roundabout");
                }
            }
        } else {
            System.out.println("Vehicle " + vehicleId + " not found in roundabout");
        }
    }
    
    public void processTrafficFlow() {
        System.out.println("\\n=== Processing Traffic Flow ===");
        
        // Simulate some vehicles exiting based on their direction
        // This is a simplified simulation
        if (!roundabout.isEmpty()) {
            System.out.println("Simulating natural traffic flow...");
            
            // In a real system, vehicles would exit based on their destination
            // Here we'll just demonstrate the concept
        }
    }
    
    public void displaySystemState() {
        System.out.println("\\n=== Traffic System State ===");
        System.out.println("Roundabout capacity: " + roundabout.getSize() + "/8");
        System.out.println("Queue size: " + waitingQueue.getSize() + "/15");
        
        roundabout.displayRoundabout();
        waitingQueue.displayQueue();
        
        // System status
        if (roundabout.isFull() && waitingQueue.isFull()) {
            System.out.println("STATUS: CRITICAL - System at full capacity!");
        } else if (roundabout.isFull()) {
            System.out.println("STATUS: BUSY - Roundabout full, using queue");
        } else if (roundabout.isEmpty() && waitingQueue.isEmpty()) {
            System.out.println("STATUS: CLEAR - No traffic");
        } else {
            System.out.println("STATUS: NORMAL - Traffic flowing");
        }
    }
    
    public void handleEmergencyVehicle(String type, String direction) {
        String vehicleId = "EMG" + String.format("%03d", vehicleCounter++);
        Vehicle emergencyVehicle = new Vehicle(vehicleId, type, direction);
        
        System.out.println("\\n🚨 EMERGENCY VEHICLE DETECTED: " + vehicleId);
        
        // Emergency vehicles get priority - force entry if needed
        if (!roundabout.addVehicle(emergencyVehicle)) {
            System.out.println("Clearing space for emergency vehicle...");
            // In real implementation, would coordinate with traffic lights
            // For demo, we'll just add to front of queue
            System.out.println("Emergency vehicle " + vehicleId + " given priority access");
        } else {
            System.out.println("Emergency vehicle " + vehicleId + " entered roundabout");
        }
    }
    
    public static void main(String[] args) {
        TrafficManager trafficManager = new TrafficManager();
        
        System.out.println("=== Smart City Roundabout Traffic Manager ===\\n");
        
        // Initial state
        trafficManager.displaySystemState();
        
        // Add vehicles to system
        System.out.println("\\n--- Adding vehicles to system ---");
        trafficManager.addVehicleToSystem("Car", "North");
        trafficManager.addVehicleToSystem("Bus", "East");
        trafficManager.addVehicleToSystem("Truck", "South");
        trafficManager.addVehicleToSystem("Car", "West");
        trafficManager.addVehicleToSystem("Motorcycle", "North");
        
        trafficManager.displaySystemState();
        
        // Add more vehicles to test queue
        System.out.println("\\n--- Adding more vehicles (testing queue) ---");
        for (int i = 0; i < 6; i++) {
            trafficManager.addVehicleToSystem("Car", "Various");
        }
        
        trafficManager.displaySystemState();
        
        // Simulate vehicles exiting
        System.out.println("\\n--- Vehicles exiting roundabout ---");
        trafficManager.exitVehicle("V001");
        trafficManager.exitVehicle("V003");
        
        trafficManager.displaySystemState();
        
        // Emergency vehicle scenario
        trafficManager.handleEmergencyVehicle("Ambulance", "Hospital");
        
        trafficManager.displaySystemState();
        
        // Test queue overflow
        System.out.println("\\n--- Testing system limits ---");
        for (int i = 0; i < 12; i++) {
            trafficManager.addVehicleToSystem("Car", "Test");
        }
        
        trafficManager.displaySystemState();
    }
}