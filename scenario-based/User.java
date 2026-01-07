public class User {
    private int userId;
    private String userName;
    private String phoneNumber;
    
    public User(int userId, String userName, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }
    
    // Getters
    public int getUserId() { return userId; }
    public String getUserName() { return userName; }
    public String getPhoneNumber() { return phoneNumber; }
    
    @Override
    public String toString() {
        return "User{ID=" + userId + ", Name='" + userName + "', Phone='" + phoneNumber + "'}";
    }
}