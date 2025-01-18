package fulf.contacts;

/* Author - Jeff Fulfer
 * 
 * Class CS-320 SNHU
 * 
 * Contact class is a simple class to hold
 * contact objects that will be created via
 * ContactService class
 */



public class Contact {
	
	// Declare object fields
	protected String ID;
	protected String firstName;
	protected String lastName;
	protected String phone;
	protected String address;
	
	
	/* Constructor with parameter checks in place.
	 * Contact object should be created within a 
	 * try-catch block for graceful error handling.
	 * */ 
	public Contact(String ID, String firstName, String lastName,
			String phone, String address) {
		
		// Check ID to ensure it meets requirements
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("ID must not be null"
					+ " or longer than 10 characters.");
		}
		
		
		// Check firstName field to ensure it meets requirements
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First name field must not"
					+ " be null or longer than 10 characters.");
		}
		
		// Check lastName field to ensure it meets requirements
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last name field must not"
					+ " be null or longer than 10 characters");
		}
		
		// Check phone field to ensure it meets requirements
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Phone field must be exactly"
					+ " 10 digits and not be null.\nDo not include dashes.");
		}
		
		// Check if phone contains only digits
		for (int i = 0; i < phone.length(); ++i) {
			if (!Character.isDigit(phone.charAt(i))) {
				throw new IllegalArgumentException("Phone field contains "
						+ "non-digit characters.");
			}
		}
		
		// Check address field meets requirements
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address field must not be"
					+ " longer than 30 characters or null");
		}
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	
}