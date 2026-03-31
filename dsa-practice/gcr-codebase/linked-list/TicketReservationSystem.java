import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    TicketNode next;
    
    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = LocalDateTime.now();
        this.next = null;
    }
}

public class TicketReservationSystem {
    private TicketNode head;
    private int totalTickets = 0;
    
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber) {
        TicketNode newNode = new TicketNode(ticketId, customerName, movieName, seatNumber);
        
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            TicketNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        totalTickets++;
        System.out.println("Ticket booked successfully - ID: " + ticketId);
    }
    
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove");
            return;
        }
        
        if (head.ticketId == ticketId && head.next == head) {
            head = null;
            totalTickets--;
            System.out.println("Ticket " + ticketId + " cancelled");
            return;
        }
        
        TicketNode temp = head;
        TicketNode prev = null;
        
        do {
            if (temp.ticketId == ticketId) {
                if (prev != null) {
                    prev.next = temp.next;
                } else {
                    TicketNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                }
                totalTickets--;
                System.out.println("Ticket " + ticketId + " cancelled");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        
        System.out.println("Ticket not found");
    }
    
    public void displayAllTickets() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }
        
        System.out.println("=== All Booked Tickets ===");
        TicketNode temp = head;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        do {
            System.out.println("Ticket ID: " + temp.ticketId + 
                             ", Customer: " + temp.customerName + 
                             ", Movie: " + temp.movieName + 
                             ", Seat: " + temp.seatNumber + 
                             ", Booked: " + temp.bookingTime.format(formatter));
            temp = temp.next;
        } while (temp != head);
    }
    
    public TicketNode searchByCustomer(String customerName) {
        if (head == null) return null;
        
        TicketNode temp = head;
        do {
            if (temp.customerName.equals(customerName)) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);
        
        return null;
    }
    
    public TicketNode searchByMovie(String movieName) {
        if (head == null) return null;
        
        TicketNode temp = head;
        do {
            if (temp.movieName.equals(movieName)) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);
        
        return null;
    }
    
    public int getTotalTickets() {
        return totalTickets;
    }
    
    public void displayTicketsByMovie(String movieName) {
        if (head == null) {
            System.out.println("No tickets found");
            return;
        }
        
        System.out.println("=== Tickets for " + movieName + " ===");
        TicketNode temp = head;
        boolean found = false;
        
        do {
            if (temp.movieName.equals(movieName)) {
                System.out.println("Ticket ID: " + temp.ticketId + 
                                 ", Customer: " + temp.customerName + 
                                 ", Seat: " + temp.seatNumber);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        
        if (!found) {
            System.out.println("No tickets found for " + movieName);
        }
    }
    
    public static void main(String[] args) {
        TicketReservationSystem trs = new TicketReservationSystem();
        
        trs.addTicket(1001, "John Doe", "Avengers", "A1");
        trs.addTicket(1002, "Jane Smith", "Inception", "B5");
        trs.addTicket(1003, "Bob Johnson", "Avengers", "A2");
        trs.addTicket(1004, "Alice Brown", "Inception", "C3");
        
        trs.displayAllTickets();
        System.out.println("Total tickets booked: " + trs.getTotalTickets());
        
        trs.displayTicketsByMovie("Avengers");
        
        TicketNode found = trs.searchByCustomer("Jane Smith");
        if (found != null) {
            System.out.println("Found ticket for Jane Smith: " + found.movieName + ", Seat: " + found.seatNumber);
        }
        
        trs.removeTicket(1002);
        System.out.println("\\nAfter cancellation:");
        trs.displayAllTickets();
        System.out.println("Total tickets booked: " + trs.getTotalTickets());
    }
}