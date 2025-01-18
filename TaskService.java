package task_service;

import java.util.Iterator;
import java.util.LinkedList;

/* Author - Jeff Fulfer
 * CS-320 SNHU
 * 
 * Task Service class will be used to instantiate and manage
 * task objects.
 */

/* Service class created with Singleton pattern to ensure
 * no more than one instance of the class is running at the
 * same time.
 */
public class TaskService {
	
	// Singleton Instance
	private static TaskService service = null;
	
	// Initial task ID
	private static int ID = 1;
	
	// Define array to hold task objects
	private static LinkedList<Task> taskList = new LinkedList<Task>();
	
	// Private constructor
	private TaskService() {
	}
	
	/* public method used to determine if task service instance
	 * has already been started. If service is already running,
	 * this method will return the active instance. Otherwise
	 * this method will instantiate a new TaskService object which
	 * is then returned.
	 * */
	public static TaskService getInstance() {
		
		// Checks private service field for null
		if (service == null) {
			// If service is null, create new TaskService object
			service = new TaskService();
		}
		
		// Return either active service instance or newly created service object
		return service;
	}
	
	// Method used to add task with unique ID
	public void addTask(String name, String description) {
		
		/* Use try-catch block to create new contact object to handle
		 * any exceptions created
		 */
		try {
			// Attempt to create task object using parameters given
			Task newTask = new Task(String.valueOf(ID), name, description);
			
			// If successful, add newly created task to our task list
			taskList.push(newTask);
			
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		// Increment our ID field for next task assignment
		ID++;
	}
	
	// method to locate task by name
	public Task searchTasks(String name) {
		
		// Create null task to return if task not found
		Task task = null;
		
		// Instantiate iterator
		Iterator<Task> taskIter = taskList.iterator();
		
		// Loop over active tasks
		while(taskIter.hasNext()) {
			
			// create temporary task object
			Task currTask = taskIter.next();
			
			// if task ID matches ID given
			if (currTask.name == name) {
				// assign next task to task object we'll return
				task = currTask;
				// break loop
				break;
			}
		}
		
		// Return task object
		return task;
	}
	
	// Method used to delete task from task list
	public void deleteTask(String ID) {
		
		// Instantiate iterator
		Iterator<Task> taskIter = taskList.iterator();
		
		// boolean used to check if task was found and removed
		Boolean found = false;
		
		// Loop over task list
		while(taskIter.hasNext()) {
			
			// temp object to hold next task
			Task currTask = taskIter.next();
			
			// Check if ID field matches ID given
			if (currTask.ID == ID) {
				// If ID matches, remove object from list
				taskList.remove(currTask);
				// Update found bool
				found = true;
				
				// Print message indicating successful removal
				System.out.println("Task " + ID + " was successfully"
						+ " removed.");
				break;
			}
			
			// print message if task Id not found
			if (!found) {
				System.out.println("Task with ID: " + ID + " not"
						+ " found.");
			}
		}
	}
	
	// method used to update task name
	public void updateTaskName(String ID, String name) {
		
		// Validate name string meets requirements
		if (name == null || name.length() > 20) {
			
			// Print error message and return if test failed
			System.out.println("Given name does not meet requirements");
			return;
		}
		
		// Instantiate iterator
		Iterator<Task> taskIter = taskList.iterator();
		
		while(taskIter.hasNext()) {
			
			// Temp object to hold next task
			Task currTask = taskIter.next();
			
			// If curr task ID matches ID given
			if (currTask.ID == ID) {
				
				// update task name
				currTask.name = name;
				
				System.out.println("Task name field updated successfully "
						+ "for task ID " + ID);
			}
		}
	}
	
	// method used to update task description
	public void updateTaskDescription(String ID, String description) {
		
		// Validate description string given
		if (description == null || description.length() > 50) {
			
			// Print error message and return
			System.out.println("Description given does not meet requirements");
			return;
		}
		
		// Instantiate iterator
		Iterator<Task> taskIter = taskList.iterator();
		
		// Loop over list 
		while(taskIter.hasNext()) {
			
			// temp object to hold next task
			Task currTask = taskIter.next();
			
			// If current task matches
			if (currTask.ID == ID) {
				
				// update task description
				currTask.description = description;
				
				System.out.println("Task description updated successfully for "
						+ "task ID " + ID);
			}
		}
	}
	
}
