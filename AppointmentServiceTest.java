package appointment_service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import java.util.Calendar;

class AppointmentServiceTest {

	// Initiate service for tests
	AppointmentService service = AppointmentService.getInstance();
	
	@Test
	@DisplayName("Test Service is Active")
	void testActiveService() {
		Assertions.assertNotNull(service);
	}
	
	@Test
	@DisplayName("Test Add Appointment")
	void testAddAppointment() {
		
		// Create Calendar object for tomorrow
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		
		Assertions.assertDoesNotThrow(() -> {
			service.addAppointment(tomorrow, "Test description");
		});
	}
	
	@Test
	@DisplayName("Test Remove Appointment")
	void testRemoveAppointment() {
		
		// Create Calendar object to add appointment
		Calendar inAnHour = Calendar.getInstance();
		inAnHour.add(Calendar.HOUR, 1);
		
		// Create appointment and return object
		Appointment newAppt = service.addAppointment(inAnHour, "test description");
		
		// Obtain ID value of new appointment we'll use to check for existence after deletion
		String newApptID = newAppt.ID;
		
		// Remove Appointment using ID
		service.removeAppointment(newApptID);
		
		// Verify appointment has been removed and null object is returned
		Assertions.assertNull(service.locateAppointment(newApptID));
	}
	
	@Test
	@DisplayName("Test Description field allows exactly 50 characters")
	void testDescriptionField() {
		
		// Create Calendar object for test case
		Calendar nextMonth = Calendar.getInstance();
		nextMonth.add(Calendar.MONTH, 1);
		
		// Create appointment with description field exactly 50 characters
		Assertions.assertNotNull(service.addAppointment(nextMonth, "This description will be"
				+ " exactly 50 characters!!!!"));
	}
	
	@Test
	@DisplayName("Test locating Appointment")
	void testLocateAppointment() {
		
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DAY_OF_YEAR, 1);
		
		Appointment testAppointment = service.addAppointment(tomorrow, "Test Description");
		
		String testAppointmentID = testAppointment.ID;
		
		Assertions.assertTrue(service.locateAppointment(testAppointmentID).ID.equals(testAppointment.ID));
	}
}
