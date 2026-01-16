import java.util.*;
import java.time.LocalDate;

// Exception Classes
class RoomNotAvailableException extends Exception {
    public RoomNotAvailableException(String message) {
        super(message);
    }
}

// Interface for pricing strategy
interface PricingStrategy {
    double calculatePrice(double basePrice, int nights);
}

// Polymorphic pricing implementations
class RegularPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice, int nights) {
        return basePrice * nights;
    }
}

class SeasonalPricing implements PricingStrategy {
    private double multiplier;
    
    public SeasonalPricing(double multiplier) {
        this.multiplier = multiplier;
    }
    
    @Override
    public double calculatePrice(double basePrice, int nights) {
        return basePrice * nights * multiplier;
    }
}

// Core Classes with Inheritance
abstract class Room {
    protected String roomNumber;
    protected String roomType;
    protected double basePrice;
    protected boolean isAvailable;
    protected int capacity;
    
    public Room(String roomNumber, String roomType, double basePrice, int capacity) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.basePrice = basePrice;
        this.capacity = capacity;
        this.isAvailable = true;
    }
    
    public abstract double getServiceCharge();
    
    // Getters and Setters
    public String getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getBasePrice() { return basePrice; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
    public int getCapacity() { return capacity; }
}

class StandardRoom extends Room {
    public StandardRoom(String roomNumber, double basePrice) {
        super(roomNumber, "Standard", basePrice, 2);
    }
    
    @Override
    public double getServiceCharge() {
        return basePrice * 0.10; // 10% service charge
    }
}

class DeluxeRoom extends Room {
    private boolean hasBalcony;
    
    public DeluxeRoom(String roomNumber, double basePrice, boolean hasBalcony) {
        super(roomNumber, "Deluxe", basePrice, 4);
        this.hasBalcony = hasBalcony;
    }
    
    @Override
    public double getServiceCharge() {
        double charge = basePrice * 0.15; // 15% service charge
        if (hasBalcony) charge += 50; // Extra charge for balcony
        return charge;
    }
    
    public boolean hasBalcony() { return hasBalcony; }
}

class Guest {
    private String guestId;
    private String name;
    private String email;
    private String phone;
    
    public Guest(String guestId, String name, String email, String phone) {
        this.guestId = guestId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    // Getters
    public String getGuestId() { return guestId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}

class Reservation {
    private String reservationId;
    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalAmount;
    private String status; // "BOOKED", "CHECKED_IN", "CHECKED_OUT", "CANCELLED"
    
    public Reservation(String reservationId, Guest guest, Room room, 
                      LocalDate checkInDate, LocalDate checkOutDate) {
        this.reservationId = reservationId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = "BOOKED";
    }
    
    // Getters and Setters
    public String getReservationId() { return reservationId; }
    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public int getNights() {
        return (int) (checkOutDate.toEpochDay() - checkInDate.toEpochDay());
    }
}

class Invoice {
    private String invoiceId;
    private Reservation reservation;
    private double roomCharges;
    private double serviceCharges;
    private double taxes;
    private double totalAmount;
    
    public Invoice(String invoiceId, Reservation reservation) {
        this.invoiceId = invoiceId;
        this.reservation = reservation;
        calculateCharges();
    }
    
    private void calculateCharges() {
        int nights = reservation.getNights();
        this.roomCharges = reservation.getRoom().getBasePrice() * nights;
        this.serviceCharges = reservation.getRoom().getServiceCharge() * nights;
        this.taxes = (roomCharges + serviceCharges) * 0.12; // 12% tax
        this.totalAmount = roomCharges + serviceCharges + taxes;
    }
    
    public void printInvoice() {
        System.out.println("\\n=== HOTEL INVOICE ===");
        System.out.println("Invoice ID: " + invoiceId);
        System.out.println("Guest: " + reservation.getGuest().getName());
        System.out.println("Room: " + reservation.getRoom().getRoomNumber() + 
                          " (" + reservation.getRoom().getRoomType() + ")");
        System.out.println("Check-in: " + reservation.getCheckInDate());
        System.out.println("Check-out: " + reservation.getCheckOutDate());
        System.out.println("Nights: " + reservation.getNights());
        System.out.println("Room Charges: $" + String.format("%.2f", roomCharges));
        System.out.println("Service Charges: $" + String.format("%.2f", serviceCharges));
        System.out.println("Taxes (12%): $" + String.format("%.2f", taxes));
        System.out.println("Total Amount: $" + String.format("%.2f", totalAmount));
        System.out.println("==================");
    }
    
    public double getTotalAmount() { return totalAmount; }
}

public class HotelReservationSystem {
    private Map<String, Room> rooms;
    private Map<String, Guest> guests;
    private Map<String, Reservation> reservations;
    private PricingStrategy pricingStrategy;
    private int reservationCounter = 1;
    private int invoiceCounter = 1;
    
    public HotelReservationSystem() {
        this.rooms = new HashMap<>();
        this.guests = new HashMap<>();
        this.reservations = new HashMap<>();
        this.pricingStrategy = new RegularPricing();
        initializeRooms();
    }
    
    private void initializeRooms() {
        // Add sample rooms
        addRoom(new StandardRoom("101", 100.0));
        addRoom(new StandardRoom("102", 100.0));
        addRoom(new DeluxeRoom("201", 200.0, true));
        addRoom(new DeluxeRoom("202", 180.0, false));
    }
    
    // CRUD Operations
    public void addRoom(Room room) {
        rooms.put(room.getRoomNumber(), room);
        System.out.println("Room added: " + room.getRoomNumber() + " (" + room.getRoomType() + ")");
    }
    
    public void registerGuest(String guestId, String name, String email, String phone) {
        Guest guest = new Guest(guestId, name, email, phone);
        guests.put(guestId, guest);
        System.out.println("Guest registered: " + name);
    }
    
    public List<Room> getAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        List<Room> available = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (isRoomAvailable(room.getRoomNumber(), checkIn, checkOut)) {
                available.add(room);
            }
        }
        return available;
    }
    
    private boolean isRoomAvailable(String roomNumber, LocalDate checkIn, LocalDate checkOut) {
        for (Reservation reservation : reservations.values()) {
            if (reservation.getRoom().getRoomNumber().equals(roomNumber) &&
                !reservation.getStatus().equals("CHECKED_OUT") &&
                !reservation.getStatus().equals("CANCELLED")) {
                
                if (!(checkOut.isBefore(reservation.getCheckInDate()) || 
                      checkIn.isAfter(reservation.getCheckOutDate()))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public String bookRoom(String guestId, String roomNumber, LocalDate checkIn, LocalDate checkOut) 
            throws RoomNotAvailableException {
        
        Guest guest = guests.get(guestId);
        Room room = rooms.get(roomNumber);
        
        if (guest == null) {
            throw new RoomNotAvailableException("Guest not found");
        }
        
        if (room == null) {
            throw new RoomNotAvailableException("Room not found");
        }
        
        if (!isRoomAvailable(roomNumber, checkIn, checkOut)) {
            throw new RoomNotAvailableException("Room not available for selected dates");
        }
        
        String reservationId = "RES" + String.format("%03d", reservationCounter++);
        Reservation reservation = new Reservation(reservationId, guest, room, checkIn, checkOut);
        
        // Calculate total amount using pricing strategy
        int nights = reservation.getNights();
        double totalPrice = pricingStrategy.calculatePrice(room.getBasePrice(), nights);
        reservation.setTotalAmount(totalPrice);
        
        reservations.put(reservationId, reservation);
        room.setAvailable(false);
        
        System.out.println("Room booked successfully. Reservation ID: " + reservationId);
        return reservationId;
    }
    
    public void checkIn(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation != null && "BOOKED".equals(reservation.getStatus())) {
            reservation.setStatus("CHECKED_IN");
            System.out.println("Guest checked in: " + reservation.getGuest().getName());
        } else {
            System.out.println("Invalid reservation or already checked in");
        }
    }
    
    public Invoice checkOut(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation != null && "CHECKED_IN".equals(reservation.getStatus())) {
            reservation.setStatus("CHECKED_OUT");
            reservation.getRoom().setAvailable(true);
            
            String invoiceId = "INV" + String.format("%03d", invoiceCounter++);
            Invoice invoice = new Invoice(invoiceId, reservation);
            
            System.out.println("Guest checked out: " + reservation.getGuest().getName());
            return invoice;
        } else {
            System.out.println("Invalid reservation or not checked in");
            return null;
        }
    }
    
    public void setPricingStrategy(PricingStrategy strategy) {
        this.pricingStrategy = strategy;
    }
    
    public void displayAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        System.out.println("\\n=== Available Rooms ===");
        List<Room> available = getAvailableRooms(checkIn, checkOut);
        for (Room room : available) {
            System.out.println(room.getRoomNumber() + " - " + room.getRoomType() + 
                             " - $" + room.getBasePrice() + "/night");
        }
    }
    
    public static void main(String[] args) {
        HotelReservationSystem hotel = new HotelReservationSystem();
        
        try {
            // Register guest
            hotel.registerGuest("G001", "John Doe", "john@email.com", "1234567890");
            
            // Display available rooms
            LocalDate checkIn = LocalDate.now().plusDays(1);
            LocalDate checkOut = LocalDate.now().plusDays(3);
            hotel.displayAvailableRooms(checkIn, checkOut);
            
            // Book room
            String reservationId = hotel.bookRoom("G001", "201", checkIn, checkOut);
            
            // Check in
            hotel.checkIn(reservationId);
            
            // Set seasonal pricing (50% premium)
            hotel.setPricingStrategy(new SeasonalPricing(1.5));
            
            // Check out and generate invoice
            Invoice invoice = hotel.checkOut(reservationId);
            if (invoice != null) {
                invoice.printInvoice();
            }
            
        } catch (RoomNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}