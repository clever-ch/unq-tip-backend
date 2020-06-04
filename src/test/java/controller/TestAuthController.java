package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import factories.PersonFactory;
import factories.UserFactory;
import modelDTO.LoginDTOFactory;
import modelDTO.PersonDTOFactory;
import modelDTO.UserDTOFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import root.DTO.LoginDTO;
import root.DTO.PersonDTO;
import root.DTO.UserDTO;
import root.controller.AuthController;
import root.model.Person;
import root.model.User;
import root.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestAuthController {
	
	@InjectMocks
	AuthController authController;
	
	@Mock
	UserRepository userRepository;
	
	@Test
	public void testNonexistentUser() {
		final String USERNAME = "", PASSWORD = "", USERGUID = "";
		
		LoginDTO loginDTO = LoginDTOFactory.getLoginDTOWithParameters(USERNAME, PASSWORD, USERGUID);
		when(userRepository.findUserByUserNameAndUserGuid(USERNAME, USERGUID)).thenReturn(null);
		
		assertFalse(authController.loggedInUserExists(loginDTO));
	}
	
	@Test
	public void testUserExistsWithUserNameAndUSerGuid() {
		final String USERNAME = "aUserName", PASSWORD = "", USERGUID = "aUserGuid";
		
		LoginDTO loginDTO = LoginDTOFactory.getLoginDTOWithParameters(USERNAME, PASSWORD, USERGUID);
		User existingUser = UserFactory.createAUserWithUserNamePasswordAndUserGuid(USERNAME, PASSWORD, USERGUID);
		
		when(userRepository.findUserByUserNameAndUserGuid(USERNAME, USERGUID)).thenReturn(existingUser);
		
		assertTrue(authController.loggedInUserExists(loginDTO));
	}
	
	@Test
	public void testUserExistsByGuid() {
		final String USERNAME = "aUserName", PASSWORD = "", USERGUID = "aUserGuid", EMAIL = "";
		
		Person person = PersonFactory.anyPerson();
		User existingUser = UserFactory.createACompleteUser(USERNAME, EMAIL, PASSWORD,  person);
		
		PersonDTO personDTO = PersonDTOFactory.anyPersonDTO();
		UserDTO existingUserDTO = UserDTOFactory.createACompleteUser(USERNAME, PASSWORD, EMAIL, personDTO);
		
		when(userRepository.findUserByUserGuid(USERGUID)).thenReturn(existingUser);
		
		ResponseEntity<UserDTO> result = authController.getUserByGuid(USERGUID);
		assertEquals(existingUserDTO.UserName, result.getBody().UserName);
		assertEquals(existingUserDTO.UserGuid, result.getBody().UserGuid);
	}
}
