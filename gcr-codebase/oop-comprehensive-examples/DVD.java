public class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable = true;
    
    public DVD(String itemId, String title, String director) {
        super(itemId, title, director);
    }
    
    @Override
    public int getLoanDuration() {
        return 3; // 3 days for DVDs
    }
    
    @Override
    public void reserveItem(String borrowerId) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("DVD reserved by: " + borrowerId);
        } else {
            System.out.println("DVD not available");
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}