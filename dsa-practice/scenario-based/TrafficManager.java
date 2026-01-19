import java.util.LinkedList;
import java.util.Queue;

class Vehicle {
    String id;
    Vehicle next;
    
    Vehicle(String id) {
        this.id = id;
    }
}

public class TrafficManager {
    private Vehicle head;
    private int roundaboutSize;
    private Queue<String> waitingQueue;
    private final int MAX_CAPACITY = 5;
    
    public TrafficManager() {
        this.waitingQueue = new LinkedList<>();
        this.roundaboutSize = 0;
    }
    
    public void addVehicleToQueue(String vehicleId) {
        if (waitingQueue.size() >= 10) {
            System.out.println("Queue overflow! Cannot add " + vehicleId);
            return;
        }
        waitingQueue.offer(vehicleId);
        System.out.println("Vehicle " + vehicleId + " added to waiting queue");
    }
    
    public void enterRoundabout() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Queue underflow! No vehicles waiting");
            return;
        }
        if (roundaboutSize >= MAX_CAPACITY) {
            System.out.println("Roundabout full! Cannot enter");
            return;
        }
        
        String vehicleId = waitingQueue.poll();
        Vehicle newVehicle = new Vehicle(vehicleId);
        
        if (head == null) {
            head = newVehicle;
            head.next = head;
        } else {
            Vehicle temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newVehicle;
            newVehicle.next = head;
        }
        roundaboutSize++;
        System.out.println("Vehicle " + vehicleId + " entered roundabout");
    }
    
    public void exitRoundabout(String vehicleId) {
        if (head == null) {
            System.out.println("Roundabout empty!");
            return;
        }
        
        if (head.id.equals(vehicleId) && head.next == head) {
            head = null;
            roundaboutSize--;
            System.out.println("Vehicle " + vehicleId + " exited roundabout");
            return;
        }
        
        Vehicle current = head;
        Vehicle prev = null;
        
        do {
            if (current.id.equals(vehicleId)) {
                if (current == head) {
                    Vehicle temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = current.next;
                }
                roundaboutSize--;
                System.out.println("Vehicle " + vehicleId + " exited roundabout");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        
        System.out.println("Vehicle " + vehicleId + " not found in roundabout");
    }
    
    public void printState() {
        System.out.println("\n=== Traffic Manager State ===");
        System.out.println("Waiting Queue: " + waitingQueue);
        System.out.print("Roundabout: ");
        
        if (head == null) {
            System.out.println("Empty");
        } else {
            Vehicle current = head;
            do {
                System.out.print(current.id + " -> ");
                current = current.next;
            } while (current != head);
            System.out.println("(circular)");
        }
        System.out.println("Roundabout Size: " + roundaboutSize + "/" + MAX_CAPACITY);
        System.out.println("=============================\n");
    }
    
    public static void main(String[] args) {
        TrafficManager tm = new TrafficManager();
        
        tm.addVehicleToQueue("CAR1");
        tm.addVehicleToQueue("CAR2");
        tm.addVehicleToQueue("CAR3");
        
        tm.enterRoundabout();
        tm.enterRoundabout();
        tm.printState();
        tm.addVehicleToQueue("CAR4");
        tm.enterRoundabout();
        tm.enterRoundabout();
        tm.printState();
        
        tm.exitRoundabout("CAR1");
        tm.exitRoundabout("CAR3");
        tm.printState();
    }
}