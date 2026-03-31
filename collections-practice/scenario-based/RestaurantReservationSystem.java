import java.util.*;

class TableAlreadyReservedException extends Exception {
    public TableAlreadyReservedException(String message) {
        super(message);
    }
}

class Table {
    int tableNumber;
    int capacity;
    boolean isReserved;
    
    Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isReserved = false;
    }
    
    @Override
    public String toString() {
        return "Table " + tableNumber + " (Capacity: " + capacity + ", Reserved: " + isReserved + ")";
    }
}

class Reservation {
    int tableNumber;
    String customerName;
    String timeSlot;
    
    Reservation(int tableNumber, String customerName, String timeSlot) {
        this.tableNumber = tableNumber;
        this.customerName = customerName;
        this.timeSlot = timeSlot;
    }
    
    @Override
    public String toString() {
        return "Table " + tableNumber + " reserved by " + customerName + " at " + timeSlot;
    }
}

public class RestaurantReservationSystem {
    private Map<Integer, Table> tables;
    private List<Reservation> reservations;
    
    public RestaurantReservationSystem() {
        this.tables = new HashMap<>();
        this.reservations = new ArrayList<>();
        initializeTables();
    }
    
    private void initializeTables() {
        tables.put(1, new Table(1, 2));
        tables.put(2, new Table(2, 4));
        tables.put(3, new Table(3, 6));
        tables.put(4, new Table(4, 2));
        tables.put(5, new Table(5, 8));
    }
    
    public void reserveTable(int tableNumber, String customerName, String timeSlot) throws TableAlreadyReservedException {
        Table table = tables.get(tableNumber);
        
        if (table == null) {
            throw new IllegalArgumentException("Table " + tableNumber + " does not exist");
        }
        
        if (table.isReserved) {
            throw new TableAlreadyReservedException("Table " + tableNumber + " is already reserved");
        }
        
        table.isReserved = true;
        reservations.add(new Reservation(tableNumber, customerName, timeSlot));
        System.out.println("Table " + tableNumber + " reserved for " + customerName + " at " + timeSlot);
    }
    
    public void cancelReservation(int tableNumber) {
        Table table = tables.get(tableNumber);
        
        if (table != null && table.isReserved) {
            table.isReserved = false;
            reservations.removeIf(r -> r.tableNumber == tableNumber);
            System.out.println("Reservation for table " + tableNumber + " cancelled");
        } else {
            System.out.println("No reservation found for table " + tableNumber);
        }
    }
    
    public void showAvailableTables() {
        System.out.println("Available Tables:");
        for (Table table : tables.values()) {
            if (!table.isReserved) {
                System.out.println(table);
            }
        }
    }
    
    public void showAllReservations() {
        System.out.println("Current Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
    
    public static void main(String[] args) {
        RestaurantReservationSystem system = new RestaurantReservationSystem();
        
        try {
            system.showAvailableTables();
            
            system.reserveTable(1, "John Doe", "7:00 PM");
            system.reserveTable(3, "Jane Smith", "8:00 PM");
            
            system.showAvailableTables();
            system.showAllReservations();
            
            // Try to double book
            system.reserveTable(1, "Bob Johnson", "7:30 PM");
            
        } catch (TableAlreadyReservedException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        system.cancelReservation(1);
        system.showAvailableTables();
    }
}