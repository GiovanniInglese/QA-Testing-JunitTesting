package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    private Contact makeValid() {
        return new Contact("1234", "James", "Gunn", "9108772908", "844 new york ave");
    }

    private String id10() {
        return "1234567890"; // 10 chars
    }

    private String name10() {
        return "ABCDEFGHIJ"; // 10 chars
    }

    private String addr30() {
        return "123456789012345678901234567890"; // 30 chars
    }

    private String phone10() {
        return "0123456789"; // 10 digits
    }

    // VALID / BOUNDARY VALID
    @Test
    void testValidContact() {
        Contact c = new Contact("3445", "James", "Gunn", "9108447065", "22 washington ln");

        assertEquals("3445", c.getContactID());
        assertEquals("James", c.getFirstName());
        assertEquals("Gunn", c.getLastName());
        assertEquals("9108447065", c.getPhone());
        assertEquals("22 washington ln", c.getaddress());
    }

    @Test
    void testBoundaryValuesAreValid() {
        assertDoesNotThrow(() -> new Contact(id10(), name10(), name10(), phone10(), addr30()));
    }

    // NULL TESTS
    @Test
    void contactIdNull_throws() {
        assertThrows(NullPointerException.class,
                () -> new Contact(null, "James", "Gunn", "9108772908", "844 new york ave"));
    }

    @Test
    void firstNameNull_throws() {
        assertThrows(NullPointerException.class,
                () -> new Contact("1234", null, "Gunn", "9108772908", "844 new york ave"));
    }

    @Test
    void lastNameNull_throws() {
        assertThrows(NullPointerException.class,
                () -> new Contact("1234", "James", null, "9108772908", "844 new york ave"));
    }

    @Test
    void phoneNull_throws() {
        assertThrows(NullPointerException.class,
                () -> new Contact("1234", "James", "Gunn", null, "844 new york ave"));
    }

    @Test
    void addressNull_throws() {
        assertThrows(NullPointerException.class,
                () -> new Contact("1234", "James", "Gunn", "9108772908", null));
    }

    // TOO LONG TESTS
    @Test
    void contactIdTooLong_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "James", "Gunn", "9108772908", "844 new york ave"));
    }

    @Test
    void firstNameTooLong_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1234", "Jamesgyrgrbedghh", "Gunn", "9108772908", "844 new york ave"));
    }

    @Test
    void lastNameTooLong_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1234", "James", "Gunnfkjnffjrrhnvk", "9108772908", "844 new york ave"));
    }

    @Test
    void addressTooLong_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1234", "James", "Gunn", "9108772908",
                        "844 new york ave down town avenue close to park far from delly bewteen south and north east and west"));
    }

    // BLANK TESTS
    @Test
    void contactIdBlank_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("   ", "James", "Gunn", "9108772908", "844 new york ave"));
    }

    @Test
    void firstNameBlank_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1234", "   ", "Gunn", "9108772908", "844 new york ave"));
    }

    @Test
    void lastNameBlank_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1234", "James", "   ", "9108772908", "844 new york ave"));
    }

    @Test
    void addressBlank_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1234", "James", "Gunn", "9108772908", "   "));
    }

    // PHONE INVALID FORMAT TESTS
    @Test
    void phoneTooLong_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1234", "James", "Gunn", "910872272908", "844 new york ave"));
    }

    @Test
    void phoneTooShort_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1234", "James", "Gunn", "12345", "844 new york ave"));
    }

    @Test
    void phoneHasLetters_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1234", "James", "Gunn", "91087ABCD8", "844 new york ave"));
    }

    // VALID SETTER TESTS
    @Test
    void setters_validUpdates_work() {
        Contact c = makeValid();

        c.setFirstName("Chris");
        c.setLastName("Evans");
        c.setPhone("9998887776");
        c.setAddress("100 main st");

        assertEquals("Chris", c.getFirstName());
        assertEquals("Evans", c.getLastName());
        assertEquals("9998887776", c.getPhone());
        assertEquals("100 main st", c.getaddress());
    }

    @Test
    void setLastNameValid() {
        Contact c = makeValid();
        c.setLastName("Smith");
        assertEquals("Smith", c.getLastName());
    }

    @Test
    void setFirstNameValid() {
        Contact c = makeValid();
        c.setFirstName("Mark");
        assertEquals("Mark", c.getFirstName());
    }

    @Test
    void setPhoneValid() {
        Contact c = makeValid();
        c.setPhone("8182344457");
        assertEquals("8182344457", c.getPhone());
    }

    @Test
    void setAddressValid() {
        Contact c = makeValid();
        c.setAddress("52 norman ln");
        assertEquals("52 norman ln", c.getaddress());
    }

    // INVALID SETTER TESTS (extra coverage)
    @Test
    void setFirstName_blank_throws() {
        Contact c = makeValid();
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("   "));
    }

    @Test
    void setFirstName_tooLong_throws() {
        Contact c = makeValid();
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("ABCDEFGHIJK")); // 11
    }

    @Test
    void setLastName_blank_throws() {
        Contact c = makeValid();
        assertThrows(IllegalArgumentException.class, () -> c.setLastName("   "));
    }

    @Test
    void setLastName_tooLong_throws() {
        Contact c = makeValid();
        assertThrows(IllegalArgumentException.class, () -> c.setLastName("ABCDEFGHIJK")); // 11
    }

    @Test
    void setPhone_invalid_throws() {
        Contact c = makeValid();
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("123"));
    }

    @Test
    void setPhone_letters_throws() {
        Contact c = makeValid();
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("12345ABCDE"));
    }

    @Test
    void setPhone_blank_throws() {
        Contact c = makeValid();
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("          ")); // 10 spaces
    }

    @Test
    void setAddress_tooLong_throws() {
        Contact c = makeValid();
        assertThrows(IllegalArgumentException.class, () -> c.setAddress("1234567890123456789012345678901")); // 31
    }

    @Test
    void setAddress_blank_throws() {
        Contact c = makeValid();
        assertThrows(IllegalArgumentException.class, () -> c.setAddress("   "));
    }
}




