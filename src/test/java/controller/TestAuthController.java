package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import modelDTO.LoginDTOFactory;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import root.DTO.LoginDTO;
import root.controller.AuthController;
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
		
		assertEquals(false, authController.loggedInUserExists(loginDTO));
	}
}
