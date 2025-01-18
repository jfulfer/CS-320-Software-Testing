package appointment_service;

import java.util.Calendar;

/* Author - Jeff Fulfer
 * CS-320 SNHU
 * 
 * Class handles the creation of appointment objects
 * that will be instantiated using the appointment 
 * service class
 */

public class Appointment {
	
	// Declare class attributes
	protected String ID;
	protected Calendar appointmentDate;
	protected String description;
	
	/* public constructor with parameter checks to ensure
	 * attributes meets requirements
	 */
	public Appointment(String ID, Calendar appointmentDate, String description) {
		
		// Check the ID parameter
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("ID must not be null or has exceeded"
					+ " 1000000000 limit");
		}
		
		// Check appointmentDate parameter
		if (appointmentDate == null || appointmentDate.before(Calendar.getInstance())) {
			throw new IllegalArgumentException("Appointment date must not be null"
					+ " or set in the past");
		}
		
		// Check description parameter
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Appointment description must not be "
					+ "null or longer than 50 characters");
		}
		
		// Assign attributes data from parameters if all tests are passed
		this.ID = ID;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}
}
