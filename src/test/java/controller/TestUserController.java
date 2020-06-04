package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import modelDTO.PersonDTOFactory;
import modelDTO.UserDTOFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import root.DTO.PersonDTO;
import root.DTO.UserDTO;
import root.controller.UserController;
import root.model.User;
import root.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestUserController {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserRepository userRepository;
	
	@Test
	public void testUserEmailIsValid() {
		final String EMAIL = "nico@gmail.com";
		
		assertTrue(userController.isValidEmail(EMAIL));
	}
	
	@Test
	public void testUserEmailIsNotValid() {
		final String EMAILWRONG = "nicogmail.com";
		
		assertFalse(userController.isValidEmail(EMAILWRONG));
	}
	
	@Test
	public void testNewUserIsCreated() {
		final String USERNAME = "aUserName", PASSWORD = "12345", EMAIL = "ausername@gmal.com";
		final String NAME = "name", SURNAME = "surname", TELEPHONE = "telephone", ADDRESS = "adress", LOCATION = "location";
		
		PersonDTO personDTO = PersonDTOFactory.createPersonComplete(NAME, SURNAME, TELEPHONE, ADDRESS, LOCATION);
		UserDTO newUserDTO = UserDTOFactory.createACompleteUser(USERNAME, EMAIL, PASSWORD, personDTO);
		
		ResponseEntity<User> result = userController.createUser(newUserDTO);
		assertEquals(newUserDTO.UserName, result.getBody().getUserName());
		assertEquals(newUserDTO.PersonDTO.Name, result.getBody().getPerson().getName());
	}
}
