import java.util.ArrayList;
import java.util.List;

class Flight {
    private String flightNumber;
    private String airline;
    private String source;
    private String destination;
    private String departureTime;
    private double price;
    private int availableSeats;
    
    public Flight(String flightNumber, String airline, String source, String destination, 
                  String departureTime, double price, int availableSeats) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.price = price;
        this.availableSeats = availableSeats;
    }
    
    public String getFlightNumber() { return flightNumber; }
    public String getAirline() { return airline; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public String getDepartureTime() { return departureTime; }
    public double getPrice() { return price; }
    public int getAvailableSeats() { return availableSeats; }
    
    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }
    
    public void cancelSeat() {
        availableSeats++;
    }
    
    @Override
    public String toString() {
        return flightNumber + " - " + airline + " (" + source + " to " + destination + 
               ") at " + departureTime + " - $" + price + " - Seats: " + availableSeats;
    }
}

class Booking {
    private String bookingId;
    private String passengerName;
    private Flight flight;
    private String bookingDate;
    private String status;
    
    public Booking(String bookingId, String passengerName, Flight flight, String bookingDate) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.flight = flight;
        this.bookingDate = bookingDate;
        this.status = "Confirmed";
    }
    
    public String getBookingId() { return bookingId; }
    public String getPassengerName() { return passengerName; }
    public Flight getFlight() { return flight; }
    public String getBookingDate() { return bookingDate; }
    public String getStatus() { return status; }
    
    public void setStatus(String status) { this.status = status; }
    
    @Override
    public String toString() {
        return "Booking ID: " + bookingId + ", Passenger: " + passengerName + 
               ", Flight: " + flight.getFlightNumber() + ", Status: " + status;
    }
}

public class FlightBookingSystem {
    private Flight[] availableFlights;
    private List<Booking> bookings;
    private int bookingCounter = 1;
    
    public FlightBookingSystem() {
        availableFlights = new Flight[] {
            new Flight("AI101", "Air India", "Delhi", "Mumbai", "08:00", 5500.0, 150),
            new Flight("6E202", "IndiGo", "Mumbai", "Bangalore", "10:30", 4200.0, 180),
            new Flight("SG303", "SpiceJet", "Delhi", "Kolkata", "14:15", 3800.0, 120),
            new Flight("UK404", "Vistara", "Bangalore", "Chennai", "16:45", 3200.0, 160),
            new Flight("AI505", "Air India", "Chennai", "Delhi", "19:20", 6000.0, 140)
        };
        
        bookings = new ArrayList<>();
    }
    
    public List<Flight> searchFlightsByDestination(String destination) {
        List<Flight> results = new ArrayList<>();
        String searchTerm = destination.toLowerCase().trim();
        
        for (Flight flight : availableFlights) {
            if (flight.getDestination().toLowerCase().contains(searchTerm)) {
                results.add(flight);
            }
        }
        
        return results;
    }
    
    public List<Flight> searchFlights(String source, String destination) {
        List<Flight> results = new ArrayList<>();
        String srcTerm = source.toLowerCase().trim();
        String destTerm = destination.toLowerCase().trim();
        
        for (Flight flight : availableFlights) {
            if (flight.getSource().toLowerCase().contains(srcTerm) && 
                flight.getDestination().toLowerCase().contains(destTerm)) {
                results.add(flight);
            }
        }
        
        return results;
    }
    public Booking bookFlight(String flightNumber, String passengerName) {
        Flight selectedFlight = null;
        
        for (Flight flight : availableFlights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                selectedFlight = flight;
                break;
            }
        }
        
        if (selectedFlight == null) {
            System.out.println("Flight not found");
            return null;
        }
        
        if (selectedFlight.getAvailableSeats() <= 0) {
            System.out.println("No seats available");
            return null;
        }
        
        selectedFlight.bookSeat();
        String bookingId = "BK" + String.format("%03d", bookingCounter++);
        Booking booking = new Booking(bookingId, passengerName, selectedFlight, "2024-01-15");
        bookings.add(booking);
        
        System.out.println("Flight booked successfully! Booking ID: " + bookingId);
        return booking;
    }
    
    public void cancelBooking(String bookingId) {
        Booking booking = findBooking(bookingId);
        
        if (booking != null) {
            booking.setStatus("Cancelled");
            booking.getFlight().cancelSeat();
            System.out.println("Booking cancelled successfully");
        } else {
            System.out.println("Booking not found");
        }
    }
    
    public Booking findBooking(String bookingId) {
        return bookings.stream()
                .filter(b -> b.getBookingId().equalsIgnoreCase(bookingId))
                .findFirst()
                .orElse(null);
    }
    
    public void displayAllFlights() {
        System.out.println("=== Available Flights ===");
        for (Flight flight : availableFlights) {
            System.out.println(flight);
        }
    }
    
    public void displayBookings() {
        System.out.println("=== All Bookings ===");
        if (bookings.isEmpty()) {
            System.out.println("No bookings found");
            return;
        }
        
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
    
    public void displayBookingsForPassenger(String passengerName) {
        System.out.println("=== Bookings for " + passengerName + " ===");
        boolean found = false;
        
        for (Booking booking : bookings) {
            if (booking.getPassengerName().equalsIgnoreCase(passengerName)) {
                System.out.println(booking);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No bookings found for " + passengerName);
        }
    }
    
    public static void main(String[] args) {
        FlightBookingSystem system = new FlightBookingSystem();
        
        system.displayAllFlights();
    
        System.out.println("\\n=== Search Results for Mumbai ===");
        List<Flight> mumbaiFlights = system.searchFlightsByDestination("Mumbai");
        mumbaiFlights.forEach(System.out::println);
        
        System.out.println("\\n=== Search Results: Delhi to Mumbai ===");
        List<Flight> delhiToMumbai = system.searchFlights("Delhi", "Mumbai");
        delhiToMumbai.forEach(System.out::println);
        
        system.bookFlight("AI101", "John Doe");
        system.bookFlight("6E202", "Jane Smith");
        system.bookFlight("AI101", "Bob Johnson");
        
        system.displayBookings();
        system.displayBookingsForPassenger("John Doe");
        
        system.cancelBooking("BK001");
        
        System.out.println("\\nAfter cancellation:");
        system.displayBookings();
    }
}