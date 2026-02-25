package Appointments;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class AppointmentTest {

    private Date futureDate() {
        return new Date(System.currentTimeMillis() + 60_000); // +1 minute
    }

    private Date pastDate() {
        return new Date(System.currentTimeMillis() - 60_000); // -1 minute
    }

    private String longDesc51() {
        return "123456789012345678901234567890123456789012345678901"; // 51 chars
    }

    private String desc50() {
        return "12345678901234567890123456789012345678901234567890"; // 50 chars
    }

   
// Valid constructor
  
    @Test
    void testValidAppointment() {
        Date d = futureDate();
        Appointment appt = new Appointment("A123", d, "Doctor visit");

        assertEquals("A123", appt.getAppointmentId());
        assertEquals(d, appt.getAppointmentDate());
        assertEquals("Doctor visit", appt.getDescription());
    }

// Appointment ID validation
  
    @Test
    void testAppointmentIdNullThrows() {
        Date d = futureDate();
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, d, "Valid desc");
        });
    }

    @Test
    void testAppointmentIdTooLongThrows() {
        Date d = futureDate();
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", d, "Valid desc"); // 11 chars
        });
    }

    @Test
    void testAppointmentIdBlankThrows() {
        Date d = futureDate();
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("   ", d, "Valid desc");
        });
    }

  //Date Validation
    @Test
    void testAppointmentDateNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A123", null, "Valid desc");
        });
    }

    @Test
    void testAppointmentDateInPastThrows() {
        Date d = pastDate();
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A123", d, "Valid desc");
        });
    }

  //Description validation
    @Test
    void testDescriptionNullThrows() {
        Date d = futureDate();
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A123", d, null);
        });
    }

    @Test
    void testDescriptionTooLongThrows() {
        Date d = futureDate();
        String longDesc = longDesc51();
        assertEquals(51, longDesc.length());

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A123", d, longDesc);
        });
    }

    @Test
    void testDescriptionBlankThrows() {
        Date d = futureDate();
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A123", d, "   ");
        });
    }

    @Test
    void testDescriptionEmptyThrows() {
        Date d = futureDate();
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A123", d, "");
        });
    }

    @Test
    void testBoundaryDescription50Valid() {
        Date d = futureDate();
        String d50 = desc50();
        assertEquals(50, d50.length());

        assertDoesNotThrow(() -> {
            new Appointment("A123", d, d50);
        });
    }

    //Setter Tests
    @Test
    void testSetAppointmentDateValid() {
        Appointment appt = new Appointment("A123", futureDate(), "Valid desc");

        Date newDate = new Date(System.currentTimeMillis() + 120_000); // +2 minutes
        appt.setAppointmentDate(newDate);

        assertEquals(newDate, appt.getAppointmentDate());
    }

    @Test
    void testSetAppointmentDatePastThrows() {
        Appointment appt = new Appointment("A123", futureDate(), "Valid desc");
        Date d = pastDate();

        assertThrows(IllegalArgumentException.class, () -> {
            appt.setAppointmentDate(d);
        });
    }

    @Test
    void testSetAppointmentDateNullThrows() {
        Appointment appt = new Appointment("A123", futureDate(), "Valid desc");

        assertThrows(IllegalArgumentException.class, () -> {
            appt.setAppointmentDate(null);
        });
    }

    @Test
    void testSetDescriptionValid() {
        Appointment appt = new Appointment("A123", futureDate(), "Valid desc");

        appt.setDescription("Updated desc");

        assertEquals("Updated desc", appt.getDescription());
    }

    @Test
    void testSetDescriptionNullThrows() {
        Appointment appt = new Appointment("A123", futureDate(), "Valid desc");

        assertThrows(IllegalArgumentException.class, () -> {
            appt.setDescription(null);
        });
    }

    @Test
    void testSetDescriptionTooLongThrows() {
        Appointment appt = new Appointment("A123", futureDate(), "Valid desc");
        String longDesc = longDesc51();
        assertEquals(51, longDesc.length());

        assertThrows(IllegalArgumentException.class, () -> {
            appt.setDescription(longDesc);
        });
    }

    @Test
    void testSetDescriptionBlankThrows() {
        Appointment appt = new Appointment("A123", futureDate(), "Valid desc");

        assertThrows(IllegalArgumentException.class, () -> {
            appt.setDescription("   ");
        });
    }

    @Test
    void testSetDescriptionEmptyThrows() {
        Appointment appt = new Appointment("A123", futureDate(), "Valid desc");

        assertThrows(IllegalArgumentException.class, () -> {
            appt.setDescription("");
        });
    }
    @Test
    void testValidateAppointmentIdValid_doesNotThrow() {
        assertDoesNotThrow(() -> Appointment.validateAppointmentId("A123"));
    }

    @Test
    void testValidateAppointmentIdBlankThrows() {
        assertThrows(IllegalArgumentException.class, () -> Appointment.validateAppointmentId("   "));
    }


    @Test
    void testValidateDescriptionValid_doesNotThrow() {
        assertDoesNotThrow(() -> Appointment.validateDescription("Valid desc"));
    }

    @Test
    void testValidateDescriptionBlankThrows() {
        assertThrows(IllegalArgumentException.class, () -> Appointment.validateDescription("   "));
    }
    @Test
    void testValidateAppointmentIdLength10Valid() {
        assertDoesNotThrow(() -> Appointment.validateAppointmentId("1234567890")); // exactly 10
    }

    @Test
    void testValidateDescriptionLength50Valid() {
        String desc50 = "12345678901234567890123456789012345678901234567890"; // 50
        assertEquals(50, desc50.length());
        assertDoesNotThrow(() -> Appointment.validateDescription(desc50));
    }

    @Test
    void testSetAppointmentDateCopiesDateObject() {
        Appointment appt = new Appointment("A123", futureDate(), "Valid desc");

        Date d = new Date(System.currentTimeMillis() + 120_000);
        appt.setAppointmentDate(d);

        // Should not be the same object reference (because Appointment copies the Date)
        assertNotSame(d, appt.getAppointmentDate());
        assertEquals(d, appt.getAppointmentDate());
    }

}



