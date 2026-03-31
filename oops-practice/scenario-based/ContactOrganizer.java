import java.util.ArrayList;
import java.util.List;

public class ContactOrganizer {
    private List<Contact> contacts = new ArrayList<>();
    
    public void addContact(String name, String phoneNumber) throws InvalidPhoneNumberException {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Contact with this phone number already exists");
                return;
            }
        }
        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact added successfully");
    }
    
    public void deleteContact(String phoneNumber) {
        contacts.removeIf(contact -> contact.getPhoneNumber().equals(phoneNumber));
        System.out.println("Contact deleted");
    }
    
    public Contact searchContact(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }
    
    public void displayContacts() {
        System.out.println("=== Contact List ===");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
    
    public static void main(String[] args) {
        ContactOrganizer organizer = new ContactOrganizer();
        
        try {
            organizer.addContact("John Doe", "9876543210");
            organizer.addContact("Jane Smith", "8765432109");
            organizer.addContact("Bob", "123"); // Invalid phone
        } catch (InvalidPhoneNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        organizer.displayContacts();
        
        Contact found = organizer.searchContact("9876543210");
        System.out.println("Found: " + (found != null ? found : "Not found"));
    }
}