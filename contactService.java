package contact;

import java.util.HashMap;
import java.util.Map;
// use hashmap for easy retrieval with key ad the unique ID
public class contactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add contact with unique ID
    public void addContact(Contact contact) {
        if (contact == null) throw new IllegalArgumentException("contact must not be null");

        String id = contact.getContactID();
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact ID already exists: " + id);
        }
        contacts.put(id, contact);
    }

    // Delete contact by ID
    public void deleteContact(String contact_id) {
        if (contact_id == null) throw new IllegalArgumentException("contactId must not be null");
        if (!contacts.containsKey(contact_id)) {
            throw new IllegalArgumentException("No contact found with ID: " + contact_id);
        }
        contacts.remove(contact_id);
    }

    // Update fields by ID (ID is never changed)
    // Pass null for any field you dont want to update.
    public void updateContact(String contact_id, String first_name, String last_name, String phone, String address) {
        if (contact_id == null) throw new IllegalArgumentException("contactId must not be null");

        Contact contact = contacts.get(contact_id);
        if (contact == null) {
            throw new IllegalArgumentException("No contact found with ID: " + contact_id);
        }

        if (first_name != null) contact.setFirstName(first_name);
        if (last_name != null)  contact.setLastName(last_name);
        if (phone != null)     contact.setPhone(phone);
        if (address != null)   contact.setAddress(address);
    }

    // Optional helper (useful for tests)
    public Contact getContact(String contact_id) {
        return contacts.get(contact_id);
    }

    // Optional helper (useful for tests)
    public int size() {
        return contacts.size();
    }
}

