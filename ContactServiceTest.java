package contact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    void testAddContactSuccessfully() {
        contactService service = new contactService();
        Contact c1 = new Contact("A123", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(c1);

        assertEquals(1, service.size());
        assertEquals("John", service.getContact("A123").getFirstName());
    }
    

    @Test
    void testAddContactRejectsDuplicateId() {
        contactService service = new contactService();
        Contact c1 = new Contact("A123", "John", "Doe", "1234567890", "123 Main St");
        Contact c2 = new Contact("A123", "Jane", "Smith", "0987654321", "456 Oak Ave");

        service.addContact(c1);

        assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));
    }

    @Test
    void testDeleteContactSuccessfully() {
        contactService service = new contactService();
        Contact c1 = new Contact("A123", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(c1);
        service.deleteContact("A123");

        assertEquals(0, service.size());
        assertNull(service.getContact("A123"));
    }

    @Test
    void testUpdateContactSuccessfully() {
        contactService service = new contactService();
        Contact c1 = new Contact("A123", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(c1);

        service.updateContact("A123", "Jane", null, "0987654321", null);

        Contact updated = service.getContact("A123");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Doe", updated.getLastName()); // unchanged
        assertEquals("0987654321", updated.getPhone());
    }

    @Test
    void addContact_nullContact_throws() {
        contactService service = new contactService();

        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> service.addContact(null));

        assertTrue(ex.getMessage().toLowerCase().contains("must not be null"));
    }

    @Test
    void addContact_duplicateId_throws() {
        contactService service = new contactService();

        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact c2 = new Contact("1", "Jane", "Smith", "0987654321", "999 Elm St");

        service.addContact(c1);

        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));

        assertTrue(ex.getMessage().contains("already exists"));
        assertTrue(ex.getMessage().contains("1"));
    }

    @Test
    void deleteContact_nullId_throws() {
        contactService service = new contactService();

        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> service.deleteContact(null));

        assertTrue(ex.getMessage().toLowerCase().contains("must not be null"));
    }

    @Test
    void deleteContact_idNotFound_throws() {
        contactService service = new contactService();

        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> service.deleteContact("doesNotExist"));

        assertTrue(ex.getMessage().toLowerCase().contains("no contact found"));
        assertTrue(ex.getMessage().contains("doesNotExist"));
    }
}

