package appointment_service;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Iterator;

/* Author - Jeff Fulfer
 * CS-320 SNHU
 * 
 * Service class that will be used in tandem with the
 * Appointment Class to manage Appointment objects
 * using in-memory data structure
 */

public class AppointmentService {
	
	// Singleton Instance
	private static AppointmentService service = null;
	
	// Initial Appointment ID
	private static int ID = 1;
	
	// Array used to manage appointment objects while service is active
	private static LinkedList<Appointment> appointments = new LinkedList<Appointment>();
	
	// Private constructor
	private AppointmentService() {
	}
	
	/* public method that will be used to verify if there is an active service
	 * instance. Method will either return an active running instance or 
	 * return a newly instantiated AppointService object to manage 
	 * Appointment objects 
	 */
	public static AppointmentService getInstance() {
		
		// Checking our private field to determine if service is active
		if (service == null) {
			
			// Initiate service using private constructor if null
			service = new AppointmentService();
		}
		
		// Return either active service or newly instantiated service object
		return service;
	}
	
	/* Method used to add appointment. Required parameters are a date object
	 *  with a date in the future and a description string no longer than 50
	 *  characters
	 */
	public Appointment addAppointment(Calendar date, String description) {
		
		// Instantiate null Appointment to return if parameters are invalid
		Appointment newAppt = null;
		
		/* Employ try-catch block to handle any exceptions thrown due to
		 * invalid parameters being passed
		 */
		try {
			// Create new appointment object
			newAppt = new Appointment(String.valueOf(ID), date, description);
			
			// If object created successfully, add appointment to list
			appointments.push(newAppt);
			
			// Display Appointment details
			System.out.println("Appointment ID: " + ID + " Date: " + date.getTime().toString());
			System.out.println("Description: " + description);
			
			// Increment internal ID integer
			ID++;
			
		} catch (IllegalArgumentException e){
			System.out.println("Error: " + e.getMessage());
		}
		
		// Return null Appointment object
		return newAppt;
	}
	
	/* Method used to delete appointment given the appointment ID
	 */
	public void removeAppointment(String ID) {
		
		// Instantiate iterator
		Iterator<Appointment> iter = appointments.iterator();
		
		// bool to check if appointment was found/removed
		Boolean found = false;
		
		// Loop over appointment list
		while(iter.hasNext()) {
			
			// Temp object to hold current next
			Appointment currAppt = iter.next();
			
			// Check if curr next object's ID matches given ID
			if (currAppt.ID.equals(ID)) {
				
				// If ID matches, remove object from list
				appointments.remove(currAppt);
				
				// Update bool
				found = true;
				
				// Print message indicating successful removal
				System.out.println("Successfully removed appointment with ID: " + ID);
				break;
			}
		}
		
		// If ID was not matched, print message
		if (!found) {
			System.out.println("Appointment with ID: " + ID + " not found.");
		}
	}
	
	/*
	 * Method used to search for an appointment by ID
	 */
	public Appointment locateAppointment(String ID) {
		
		// Instantiate iterator
		Iterator<Appointment> iter = appointments.iterator();
		
		// Null Appointment to return if appointment not found
		Appointment appointment = null;
		
		while(iter.hasNext()) {
			
			// Temp object to hold current appointment to check ID
			Appointment currAppt = iter.next();
			
			// If current appointment's ID matches ID given
			if (currAppt.ID == ID) {
				
				// Assign to appointment object
				appointment = currAppt;
				break;
			}
		}
		
		// Return appointment if found or return null object
		return appointment;
	}
}
