package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Contact;

public class ContactDAO {

    private final List<Contact> contacts = new ArrayList<>();

    public synchronized void add(Contact contact) {
        contacts.add(contact);
    }

    public synchronized List<Contact> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(contacts));
    }

    public synchronized Contact findById(String id) {
        for (Contact c : contacts) {
            if (c.getId() != null && c.getId().equals(id)) return c;
        }
        return null;
    }
}