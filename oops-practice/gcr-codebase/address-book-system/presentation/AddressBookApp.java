package presentation;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import model.Contact;
import service.ContactService;

public class AddressBookApp {

    private static final ContactService service = new ContactService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Address Book - Add a new contact");

        System.out.print("First name: ");
        String first = scanner.nextLine().trim();

        System.out.print("Last name: ");
        String last = scanner.nextLine().trim();

        System.out.print("Phone: ");
        String phone = scanner.nextLine().trim();

        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Address (optional): ");
        String address = scanner.nextLine().trim();

        System.out.print("City (optional): ");
        String city = scanner.nextLine().trim();

        System.out.print("State (optional): ");
        String state = scanner.nextLine().trim();

        System.out.print("ZIP (optional): ");
        String zip = scanner.nextLine().trim();

        String id = UUID.randomUUID().toString();

        Contact contact = new Contact(id, first, last, phone, address, city, state, zip, email);

        try {
            service.addContact(contact);
            System.out.println("Contact added successfully:\n" + contact);
        } catch (IllegalArgumentException ex) {
            System.err.println("Failed to add contact: " + ex.getMessage());
            scanner.close();
            return;
        }

        System.out.println("\nAll contacts:");
        List<Contact> all = service.listContacts();
        for (Contact c : all) {
            System.out.println(c);
        }

        scanner.close();
    }
}