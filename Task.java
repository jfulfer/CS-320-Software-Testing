package task_service;

/* Author: Jeff Fulfer
 * CS-320 SNHU
 * 
 * Class used to create task objects that
 * will be instantiated by the task service class
 */

public class Task {
	
	// Declare class attributes
	protected String ID;
	protected String name;
	protected String description;
	
	/* public constructor with parameter checks in
	 * place to ensure attributes are initialized 
	 * within requirements
	 */
	public Task(String ID, String name, String description) {
		
		// Check ID parameter to ensure it meets requirements
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("ID must not be "
					+ "null or longer than 10 characters");
		}
		
		// Check name parameter to ensure it meets requirements
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Name field must "
					+ "not be null or longer than 20 characters");
		}
		
		// Check description parameter to ensure it meets requirements
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description field "
					+ "must not be null or longer than 50 characters");
		}
		
		// If all parameters are within requirements, assign them to
		// object
		this.ID = ID;
		this.name = name;
		this.description = description;
	}
}
