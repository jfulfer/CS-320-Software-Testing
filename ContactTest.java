package fulf.contacts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ContactTest {

	@Test
	@DisplayName("Test instantiating a Contact object with proper values")
	void testContact() {
		Contact contact = new Contact("1", "Jeff", "Fulfer", "8609208000", "123 Sample Dr Richmond, VA");
		assertTrue(contact.ID.equals("1"));
		assertTrue(contact.firstName.equals("Jeff"));
		assertTrue(contact.lastName.equals("Fulfer"));
		assertTrue(contact.phone.equals("8609208000"));
		assertTrue(contact.address.equals("123 Sample Dr Richmond, VA"));
	}
	
	@Test
	@DisplayName("Testing firstNames longer than 10 characters throws an exception")
	void testContactFirstNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Jeffreyyyyy", "Fulfer", "8609208000", "123 Sample Dr Richmond, VA");
		});
	}
	
	@Test
	@DisplayName("Testing firstNames equal to null throws an exception")
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", null, "Fulfer", "8609208000", "123 Sample Dr Richmond, VA");
		});
	}
	
	@Test
	@DisplayName("Testing lastName longer than 10 characters throws an exception")
	void testContactLastNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Jeff", "FFulferrrrr", "8609208000", "123 Sample Dr Richmond, VA");
		});
	}
	
	@Test
	@DisplayName("Testing lastName equal to null throws an exception")
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Jeff", null, "8609208000", "123 Sample Dr Richmond, VA");
		});
	}
	
	@Test
	@DisplayName("Testing phone number provided with dashes throws an exception")
	void testContactPhone() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Jeff", "Fulfer", "860-920-8000", "123 Sample Dr Richmond, VA");
		});
	}
	
	@Test
	@DisplayName("Testing address longer than 30 characters throws an exception")
	void testContactAddressLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Jeff", "Fulfer", "8609208000", "123456 Sample Dr Richmond, VA 72345");
		});
	}
	
	@Test
	@DisplayName("Test adding a phone number with non-digit characters throws exception")
	void testInvalidNumber() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Jeff", "Fulfer", "860abc8000", "123 Test Address");
		});
	}

}
