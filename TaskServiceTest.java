package task_service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

class TaskServiceTest {
	
	// Activate Task Service for subsequent tests
	TaskService service = TaskService.getInstance();

	@Test
	@Order(1)
	@DisplayName("Test adding a new task")
	void testCreateTask() {
		Assertions.assertDoesNotThrow(() -> {
			service.addTask("task name", "task description");
		});
	}
	
	@Test
	@Order(2)
	@DisplayName("Test deleting a contact")
	void testDeleteTask() {
		service.addTask("delete", "task");
		Task taskToDel = service.searchTasks("delete");
		service.deleteTask(taskToDel.ID);
		assertNull(service.searchTasks("delete"));
	}
	
	@Test
	@Order(3)
	@DisplayName("Test updating task name")
	void testUpdateName() {
		service.addTask("task one", "description");
		Task testTask = service.searchTasks("task one");
		service.updateTaskName(testTask.ID, "updatedName");
		assertTrue(testTask.name.equals("updatedName"));
	}
	
	@Test
	@Order(4)
	@DisplayName("Test updating task description")
	void testUpdateDescription() {
		Task testTask = service.searchTasks("updatedName");
		service.updateTaskDescription(testTask.ID, "updatedDescription");
		assertTrue(testTask.description.equals("updatedDescription"));
	}

}
