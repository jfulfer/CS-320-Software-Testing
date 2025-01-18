package fulf.contacts;

import java.util.Iterator;
import java.util.LinkedList;

/* Author - Jeff Fulfer
 * 
 * Class CS-320 SNHU
 * 
 * Service class to be used to create Contact objects
 * using the Contact class. Contact object have the 
 * following required fields:
 * 
 * - contact ID (String type no longer than 10 characters)
 * - firstName (String type no longer than 10 characters)
 * - lastName (String type no longer than 10 characters)
 * - phone (String type that must be exactly 10 digits)
 * - address (String type that no longer than 30 characters)
 * 
 * All fields must not be null
 * 
 */

public class ContactService {
	
	// Singleton Instance
	private static ContactService service = null;
	
	// Initial contact ID
	private static int ID = 1;
	
	// Define array to hold contact objects
	private static LinkedList<Contact> contacts = new LinkedList<Contact>();
	
	// Private constructor
	private ContactService() {
		
	}
	
	/* Public method used to verify only single instance of 
	 * service will be instantiated by checking private 
	 * service field for null. If so, method will create
	 * a new service instance. If not, method will return
	 * active service instance.
	 */
	public static ContactService getInstance() {
		
		// Check private service field for null
		if (service == null) {
			service = new ContactService();
		}
		
		return service;
	}
	
	// Method to search for contact by full name
	public Contact searchContacts(String firstName, String lastName) {
		
		// Create null contact in case contact is not found
		Contact contact = null;
		
		// Instantiate iterator to use for searching
		Iterator<Contact> myIterator = contacts.iterator();
		
		// Loop to search for contact
		while(myIterator.hasNext()) {
			
			Contact currContact = myIterator.next();
			
			if (currContact.lastName == lastName) {
				if (currContact.firstName == firstName) {
					contact = currContact;
					break;
				}
			}
		}
		
		// Return either found contact or null object
		return contact;
	}
	
	// Method to add a new contact
	public void addContact(String firstName, String lastName,
			String phone, String address) {
		
		/* Use try-catch block to create new contact object
		 * and add to our contacts list
		 */
		try {
			Contact contact = new Contact(String.valueOf(ID), firstName, lastName, 
					phone, address);
			
			// If successful, add object to our contacts list
			contacts.push(contact);
			
			/* Increment our ID field to ensure next contact is added
			 * with unique ID
			 */
			ID++;
			
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	// Method to delete contact using ID
	public void deleteContact(String ID) {
		
		// Instantiate iterator to use for searching list
		Iterator<Contact> myIterator = contacts.iterator();
		
		// Used to check if ID was found and deleted
		Boolean found = false;
		
		// Loop over list until ID is found
		while(myIterator.hasNext()) {
			
			Contact currContact = myIterator.next();
			
			if (currContact.ID == ID) {
				contacts.remove(currContact);
				found = true;
				
				System.out.println("Contact " + ID + " was successfully deleted");
				break;
			}
		}
		
		// Display message if ID not found
		if (!found) {
			System.out.println("Contact with ID " + ID + " not found.");
		}
	}
	
	// Method used to update contact first name
	public void updateFirstName(String ID, String firstName) {
		
		// Validate firstName string given before searching
		if (firstName.length() > 10|| firstName == null) {
			
			// Print error message and return
			System.out.println("First name cannot be longer than 10"
					+ " characters and must not be null.");
			return;
		}
		
		// Instantiate iterator to use for locating contact
		Iterator<Contact> myIterator = contacts.iterator();
		
		// Loop over list searching for contact ID
		while(myIterator.hasNext()) {
			
			Contact currContact = myIterator.next();
			
			if (currContact.ID == ID) {
				
				// If contact ID is found, update firstName field
				currContact.firstName = firstName;
				
				System.out.println("First name updated successfully for "
						+ "contact" + ID);
			}
		}
	}
	
	// Method used to update contact last name
	public void updateLastName(String ID, String lastName) {
		
		// Validate lastName string given before searching
		if (lastName.length() > 10 || lastName == null) {
			
			// Print error message and return
			System.out.println("Last name cannot be longer than 10"
					+ " characters and must not be null.");
			return;
		}
		
		// Instantiate iterator to use for locating contact
		Iterator<Contact> myIterator = contacts.iterator();
		
		// Loop over list searching for contact ID
		while(myIterator.hasNext()) {
			
			Contact currContact = myIterator.next();
			
			if (currContact.ID == ID) {
						
				// If contact ID is found, update lastName field
				currContact.lastName = lastName;
				
				System.out.println("Last name updated successfully for contact "
						+ ID);
			}
		}
	}
	
	// Method used to update contact number
	public void updatePhone(String ID, String phone) {
		
		// Validate phone string given before searching
		if (phone == null || phone.length() != 10) {
			
			// Print error message and return
			System.out.println("Phone must be exactly 10 digits and "
					+ "must not be null");
			return;
		}
		
		// Validate only digits are within phone string
		for (int i = 0; i < phone.length(); ++i) {
			if (!Character.isDigit(phone.charAt(i))) {
				
				// Print error message and return
				System.out.println("Phone contains non-digit characters.");
				
				return;
			}
		}
		
		// Instantiate iterator to use for locating contact
		Iterator<Contact> myIterator = contacts.iterator();
		
		// Loop over list searching for contact ID
		while(myIterator.hasNext()) {
			
			Contact currContact = myIterator.next();
			
			if (currContact.ID == ID) {
				
				// If contact ID is found, update phone field
				currContact.phone = phone;
				
				System.out.println("Phone updated successfully for contact "
						+ ID);
			}
		}
	}
	
	// Method used to update contact address
	public void updateAddress(String ID, String address) {
		
		// Validate address before searching
		if (address.length() > 30 || address == null) {
			
			// print error message and return
			System.out.println("Address must not be longer than 30 characters"
					+ " and must not be null");
			return;
		}
		
		// Instantiate iterator to use for locating contact
		Iterator<Contact> myIterator = contacts.iterator();
		
		while(myIterator.hasNext()) {
			
			Contact currContact = myIterator.next();
			
			if (currContact.ID == ID) {
				
				// If contact ID is found, update address field
				currContact.address = address;
				
				System.out.println("Address updated successfully for contact "
						+ ID);
			}
		}
	}
}