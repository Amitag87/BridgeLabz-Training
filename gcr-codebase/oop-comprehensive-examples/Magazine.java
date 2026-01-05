public class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable = true;
    
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 7; // 7 days for magazines
    }
    
    @Override
    public void reserveItem(String borrowerId) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Magazine reserved by: " + borrowerId);
        } else {
            System.out.println("Magazine not available");
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}