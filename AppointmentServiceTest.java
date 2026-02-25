package Appointments;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;


public class AppointmentServiceTest {
	
	private Date futureDate() {
		return new Date(System.currentTimeMillis() + 60_00);//+1 minute
	}
	
	
	@Test
	
	void testAddAppointmentSuccess() {
		AppointmentService service = new AppointmentService();
		Appointment appt = new Appointment("A1", futureDate(), "checkup");
		
		service.addAppointment(appt);
		
		assertEquals(1,service.size());
		assertNotNull(service.getAppointment("A1"));
		
	}
	
    @Test
    void testAddAppointmentNullThrows() {
        AppointmentService service = new AppointmentService();

        assertThrows(IllegalArgumentException.class, () ->
            service.addAppointment((Appointment) null)
        );
    }
    
    
    @Test
    void testAddAppointmentDiplicateIDThrows() {
    	AppointmentService service = new AppointmentService();
    	
    	service.addAppointment(new Appointment("A1", futureDate(), "First"));
    	
    	assertThrows(IllegalArgumentException.class,() -> 
    	service.addAppointment(new Appointment("A1", futureDate(), "Duplicate")));
    }
    
    
    @Test
    void testDeleteAppointmentSuccess() {
    	AppointmentService service = new AppointmentService();
    	service.addAppointment(new Appointment("A1", futureDate(), "check"));
    	
    	service.deleteAppointment("A1");
    	assertEquals(0,service.size());
    	assertNull(service.getAppointment("A1"));
    	
    	
    	
    }
    
    
    @Test
    
    void testDeleteAppointmentNullIdThrows() {
    	AppointmentService service = new AppointmentService();
    	
    	assertThrows(IllegalArgumentException.class,()-> 
    	service.deleteAppointment(null));
    	
    	
    }
    
    
    @Test
    void testDeleteAppointmentMissingIDThrows() {
    	AppointmentService service = new AppointmentService();
    	
    	assertThrows(IllegalArgumentException.class,()->service.deleteAppointment("MISSING"));
    	
    }
}
