public class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked;
    
    public MovieTicket() {
        this.isBooked = false;
    }
    
    public void bookTicket(String movieName, String seatNumber, double price) {
        if (!isBooked) {
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }
    
    public void displayTicket() {
        if (isBooked) {
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        } else {
            System.out.println("Ticket have not booked yet....");
        }
    }
    
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        
        ticket.displayTicket();
        ticket.bookTicket("Dragon", "A10", 120.0);
        ticket.bookTicket("Dragon", "A11", 120.0);
        ticket.bookTicket("Dragon", "A12", 120.0);
        System.out.println();
        ticket.displayTicket();
    }
}