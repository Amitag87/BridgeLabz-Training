import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("B001", "Java Programming", "John Smith"));
        items.add(new Magazine("M001", "Tech Today", "Editor"));
        items.add(new DVD("D001", "Learning Java", "Director"));
        
        System.out.println("=== Library Management System ===");
        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            
            if (item instanceof Reservable) {
                Reservable reservable = (Reservable) item;
                System.out.println("Available: " + reservable.checkAvailability());
                reservable.reserveItem("USER001");
            }
            System.out.println();
        }
    }
}