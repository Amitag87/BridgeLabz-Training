public interface Reservable {
    void reserveItem(String borrowerId);
    boolean checkAvailability();
}