import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class TrackingNode {
    String stage;
    String location;
    String timestamp;
    TrackingNode next;
    
    TrackingNode(String stage, String location) {
        this.stage = stage;
        this.location = location;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}

public class ParcelTracker {
    private String parcelId;
    private TrackingNode head;
    private TrackingNode current;
    private boolean isLost;
    
    public ParcelTracker(String parcelId) {
        this.parcelId = parcelId;
        this.isLost = false;
    }
    
    public void addStage(String stage, String location) {
        TrackingNode newNode = new TrackingNode(stage, location);
        
        if (head == null) {
            head = newNode;
            current = head;
        } else {
            current.next = newNode;
            current = newNode;
        }
        
        System.out.println("Parcel " + parcelId + " - " + stage + " at " + location);
    }
    
    public void addCustomCheckpoint(String checkpoint, String location) {
        addStage("CHECKPOINT: " + checkpoint, location);
    }
    
    public void markAsLost(String lastKnownLocation) {
        isLost = true;
        addStage("LOST", lastKnownLocation);
        current.next = null; // Break the chain
        System.out.println("⚠️ Parcel " + parcelId + " marked as LOST!");
    }
    
    public void recoverParcel(String foundLocation) {
        if (!isLost) {
            System.out.println("Parcel is not lost!");
            return;
        }
        
        isLost = false;
        addStage("RECOVERED", foundLocation);
        System.out.println("✅ Parcel " + parcelId + " recovered!");
    }
    
    public void trackParcel() {
        System.out.println("\n=== Tracking Parcel " + parcelId + " ===");
        
        if (head == null) {
            System.out.println("No tracking information available");
            return;
        }
        
        TrackingNode temp = head;
        int step = 1;
        
        while (temp != null) {
            String status = temp == current ? " <- CURRENT" : "";
            System.out.println(step + ". " + temp.stage + " | " + temp.location + " | " + temp.timestamp + status);
            temp = temp.next;
            step++;
        }
        
        if (isLost) {
            System.out.println("🚨 STATUS: LOST - Investigation in progress");
        } else if (current != null && current.stage.equals("DELIVERED")) {
            System.out.println("✅ STATUS: DELIVERED");
        } else {
            System.out.println("📦 STATUS: IN TRANSIT");
        }
        System.out.println("=====================================\n");
    }
    
    public String getCurrentStage() {
        if (current == null) return "NO TRACKING";
        return current.stage;
    }
    
    public boolean isDelivered() {
        return current != null && current.stage.equals("DELIVERED");
    }
    
    public boolean isParcelLost() {
        return isLost;
    }
    
    public static void main(String[] args) {
        // Create parcel tracker
        ParcelTracker tracker = new ParcelTracker("PKG001");
        
        // Normal delivery flow
        tracker.addStage("PACKED", "Warehouse Mumbai");
        tracker.addStage("SHIPPED", "Mumbai Sorting Center");
        tracker.addCustomCheckpoint("Security Check", "Mumbai Airport");
        tracker.addStage("IN TRANSIT", "Delhi Hub");
        
        tracker.trackParcel();
        
        // Simulate lost parcel
        tracker.markAsLost("Delhi Hub");
        tracker.trackParcel();
        
        // Recover parcel
        tracker.recoverParcel("Delhi Recovery Center");
        tracker.addStage("IN TRANSIT", "Bangalore Hub");
        tracker.addCustomCheckpoint("Quality Check", "Bangalore Facility");
        tracker.addStage("OUT FOR DELIVERY", "Bangalore Local");
        tracker.addStage("DELIVERED", "Customer Address");
        
        tracker.trackParcel();
        
        System.out.println("Final Status: " + tracker.getCurrentStage());
        System.out.println("Is Delivered: " + tracker.isDelivered());
        System.out.println("Is Lost: " + tracker.isParcelLost());
    }
}