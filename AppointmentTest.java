package appointment_service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Calendar;

class AppointmentTest {

	@Test
	@DisplayName("Test Creating Appointment Object")
	void testCreateAppointment() {
		
		// Create Calendar object that will be set to tomorrow's date during testing
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		
		Appointment newAppointment = new Appointment("1", tomorrow, "Appointment Description");
		assertTrue(newAppointment.ID.equals("1"));
		assertTrue(newAppointment.appointmentDate.equals(tomorrow));
		assertTrue(newAppointment.description.equals("Appointment Description"));
	}
	
	@Test
	@DisplayName("Test Appointment with a date in the past cannot be created")
	void testValidDate() {
		
		// Create Calendar object set to yesterday's date during testing
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DAY_OF_MONTH, -1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("2", yesterday, "description");
		});
	}
	
	@Test
	@DisplayName("Test Appointment with null date cannot be created")
	void testNullDate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("3", null, "description");
		});
	}
	
	@Test
	@DisplayName("Test Appointment Description Requirements")
	void testDescriptionLength() {
		
		// Create Calendar object to use with test
		Calendar nextWeek = Calendar.getInstance();
		nextWeek.add(Calendar.DAY_OF_MONTH, 7);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("4", nextWeek, "veeeerrrrryyyyyyyyyylloooooooooonnnnggggdescrippttiooonnnnnnn");
		});
	}
	
	@Test
	@DisplayName("Test Invalid ID")
	void testInvalidID() {
		Calendar today = Calendar.getInstance();
		today.add(Calendar.HOUR, 1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, today, "Description Test");
		});
	}
}
