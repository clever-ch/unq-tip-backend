package modelDTO;

import root.DTO.PersonDTO;
import root.DTO.UserDTO;

public class UserDTOFactory {

	public static UserDTO anEmptyUserDTO()
	{
		return new UserDTO();
	}
	
	public static UserDTO getUserDTOWithUserGuid(String aUserGuid)
	{
		UserDTO newUserDTO = anEmptyUserDTO();
		newUserDTO.UserGuid = aUserGuid;
		
		return newUserDTO;
	}
	
	public static UserDTO createACompleteUser(String userName, String email, PersonDTO personDTO) {
		UserDTO userDTO = new UserDTO();
		userDTO.UserName = userName;
		userDTO.Email = email;
		userDTO.PersonDTO = personDTO;
		
		return userDTO;
	}
}
