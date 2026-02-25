package Appointments;

import java.util.Date;

public class Appointment {
    private final String appointmentId;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentId, Date appointmentDate, String description) {
        validateAppointmentId(appointmentId);
        validateAppointmentDate(appointmentDate);
        validateDescription(description);

        this.appointmentId = appointmentId;
        this.appointmentDate = new Date(appointmentDate.getTime());
        this.description = description;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return new Date(appointmentDate.getTime());
    }

    public String getDescription() {
        return description;
    }

    public void setAppointmentDate(Date appointmentDate) {
        validateAppointmentDate(appointmentDate);
        this.appointmentDate = new Date(appointmentDate.getTime());
    }

    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }

    // Validation helpers
    public static void validateAppointmentId(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null.");
        }
        if (appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID cannot be longer than 10 chars.");
        }
        if (appointmentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Appointment ID must not be blank.");
        }
    }

    public static void validateAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment Date must not be null");
        }

        Date now = new Date();
        if (appointmentDate.before(now)) {
            throw new IllegalArgumentException("Appointment Date must not be in the past");
        }
    }

    public static void validateDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description must not be null.");
        }
        if (description.length() > 50) {
            throw new IllegalArgumentException("Description must be <= 50 chars.");
        }
        if (description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be blank");
        }
    }
}
