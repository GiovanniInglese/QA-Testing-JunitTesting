package Appointments;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class AppointmentService {

    private final Map<String, Appointment> appointmentMap = new HashMap<>();

    // Add appointment with unique ID
    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }

        String id = appointment.getAppointmentId();

        if (appointmentMap.containsKey(id)) {
            throw new IllegalArgumentException("Appointment ID already exists: " + id);
        }

        appointmentMap.put(id, appointment);
    }

   

    // Delete appointment by ID
    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null.");
        }

        if (!appointmentMap.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found: " + appointmentId);
        }

        appointmentMap.remove(appointmentId);
    }

    // Helper methods (useful for tests)
    public Appointment getAppointment(String appointmentId) {
        return appointmentMap.get(appointmentId);
    }

    public int size() {
        return appointmentMap.size();
    }
}
