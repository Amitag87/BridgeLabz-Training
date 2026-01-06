public class Contact {
    private String name;
    private String phoneNumber;
    
    public Contact(String name, String phoneNumber) throws InvalidPhoneNumberException {
        if (phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits");
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    
    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}