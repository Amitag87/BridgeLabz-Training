public class Book extends LibraryItem implements Reservable {
    private boolean isAvailable = true;
    private String reservedBy;
    
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 14; // 14 days for books
    }
    
    @Override
    public void reserveItem(String borrowerId) {
        if (isAvailable) {
            isAvailable = false;
            reservedBy = borrowerId;
            System.out.println("Book reserved by: " + borrowerId);
        } else {
            System.out.println("Book not available");
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}