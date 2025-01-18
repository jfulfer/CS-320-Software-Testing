package task_service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	@DisplayName("Test creating Test object")
	void testTask() {
		Task newTask = new Task("1", "outlook", "email program");
		assertTrue(newTask.ID.equals("1"));
		assertTrue(newTask.name.equals("outlook"));
		assertTrue(newTask.description.equals("email program"));
	}
	
	@Test
	@DisplayName("Test name field length requirements")
	void testTaskNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "outlook12345tgdvbg2912", "description");
		});
	}
	
	@Test
	@DisplayName("Test name field for null")
	void testTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", null, "description");
		});
	}
	
	@Test
	@DisplayName("Test description field length requirements")
	void testTaskDescriptionLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "name", "vvvvveeeeeerylllllooooooongdescriptiiiiiionnnnnnnnnnn");
		});
	}
	
	@Test
	@DisplayName("Test description field for null")
	void testTaskDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "name", null);
		});
	}
}
