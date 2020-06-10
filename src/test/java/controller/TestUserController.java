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
import static org.mockito.Mockito.when;

import root.DTO.PersonDTO;
import root.DTO.UserDTO;
import root.controller.UserController;
import root.controller.exceptions.EmailInvalidException;
import root.model.User;
import root.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestUserController {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserRepository userRepository;
	
	@Test(expected = EmailInvalidException.class)
	public void testUserEmailIsNotValid() {
		
		final String USERNAME = "aUserName", PASSWORD = "12345", EMAILWRONG = "ausernamegmal.com";
		final String NAME = "name", SURNAME = "surname", TELEPHONE = "telephone", ADDRESS = "adress", LOCATION = "location";
		
		PersonDTO personDTO = PersonDTOFactory.createPersonComplete(NAME, SURNAME, TELEPHONE, ADDRESS, LOCATION);

		UserDTO newUserDTO = UserDTOFactory.createACompleteUser(USERNAME, EMAILWRONG, PASSWORD, personDTO);
		
		when(userController.createUser(newUserDTO)).thenThrow(EmailInvalidException.class);	
		
	}
	
	@Test
	public void testUserEmailIsValid() {
		final String USERNAME = "aUserName", PASSWORD = "12345", EMAILWRONG = "ausername@gmail.com";
		final String NAME = "name", SURNAME = "surname", TELEPHONE = "telephone", ADDRESS = "adress", LOCATION = "location";
		
		PersonDTO personDTO = PersonDTOFactory.createPersonComplete(NAME, SURNAME, TELEPHONE, ADDRESS, LOCATION);

		UserDTO newUserDTO = UserDTOFactory.createACompleteUser(USERNAME, EMAILWRONG, PASSWORD, personDTO);
		
		ResponseEntity<User> result = userController.createUser(newUserDTO);
		
		assertEquals(result.getBody().getEmail(), newUserDTO.Email);
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
