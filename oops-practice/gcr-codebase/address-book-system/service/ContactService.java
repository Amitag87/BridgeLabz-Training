package service;

import java.util.List;

import dao.ContactDAO;
import model.Contact;

public class ContactService {

    private final ContactDAO dao = new ContactDAO();

    public Contact addContact(Contact contact) {
    
        if (contact == null) throw new IllegalArgumentException("contact is required");
        if (contact.getFirstName() == null || contact.getFirstName().trim().isEmpty())
            throw new IllegalArgumentException("first name is required");
        if (contact.getLastName() == null || contact.getLastName().trim().isEmpty())
            throw new IllegalArgumentException("last name is required");

        dao.add(contact);
        return contact;
    }

    public List<Contact> listContacts() {
        return dao.findAll();
    }
}