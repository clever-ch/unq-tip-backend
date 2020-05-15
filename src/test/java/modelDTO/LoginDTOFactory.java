package modelDTO;

import root.DTO.LoginDTO;

public class LoginDTOFactory {

	public static LoginDTO anEmptyLoginDTO()
	{
		return new LoginDTO();
	}
	
	public static LoginDTO getLoginDTOWithParameters(String username, String password, String userGuid)
	{
		LoginDTO newLoginDTO = anEmptyLoginDTO();
		newLoginDTO.Username = username;
		newLoginDTO.Password = password;
		newLoginDTO.UserGuid = userGuid;
		
		return newLoginDTO;
	}
}
