package fulf.contacts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactServiceTest {
	
	// Instantiate service for all tests to use
	ContactService service = ContactService.getInstance();	
	
	@Test
	@Order(1)
	@DisplayName("Test adding a contact")
	void testContactAdd() {
		service.addContact("Jeff", "Fulfer", "8609208000", "123 Simple Dr Richmond. VA");
		assertNotNull(service.searchContacts("Jeff", "Fulfer"));
	}
	
	@Test
	@Order(2)
	@DisplayName("Test Deleteing a contact")
	void testContactDelete() {
		service.addContact("Delete", "Me", "1234567890", "Mystery Lane");
		Contact contactToDelete = service.searchContacts("Delete", "Me");
		String contactID = contactToDelete.ID;
		service.deleteContact(contactID);
		assertNull(service.searchContacts("Delete", "Me"));
	}
	
	@Test
	@Order(3)
	@DisplayName("Test updating contact first name")
	void testContactUpdateFirstName() {
		Contact contactToUpdate = service.searchContacts("Jeff", "Fulfer");
		service.updateFirstName(contactToUpdate.ID, "Kobe");
		assertTrue(contactToUpdate.firstName.equals("Kobe"));
	}
	
	@Test
	@Order(4)
	@DisplayName("Test updating contact last name")
	void testContactUpdateLastName() {
		Contact contactToUpdate = service.searchContacts("Kobe", "Fulfer");
		service.updateLastName(contactToUpdate.ID, "Bryant");
		assertTrue(contactToUpdate.lastName.equals("Bryant"));
	}
	
	@Test
	@Order(5)
	@DisplayName("Test updating contact phone")
	void testContactUpdatePhone() {
		Contact contactToUpdate = service.searchContacts("Kobe", "Bryant");
		service.updatePhone(contactToUpdate.ID, "8609208001");
		assertTrue(contactToUpdate.phone.equals("8609208001"));
	}
	
	@Test
	@Order(6)
	@DisplayName("Test updating contact address")
	void testContactUpdateAddress() {
		Contact contactToUpdate = service.searchContacts("Kobe", "Bryant");
		service.updateAddress(contactToUpdate.ID, "Staples Center");
		assertTrue(contactToUpdate.address.equals("Staples Center"));
	}
	

}
