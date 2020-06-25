package root.transformers;

import root.DTO.UserDTO;
import root.model.Publication;
import root.model.User;

public class UserTransformer {
	
	public static User ConvertUserDTOToUser(UserDTO userDTO) {
		User user = new User();
		user.setEmail(userDTO.Email);
		user.setPassword(userDTO.Password);
		user.setUserName(userDTO.UserName);
		user.setUserGuid(userDTO.UserGuid);
		user.setPerson(PersonTransformer.ConvertPersonDTOToPerson(userDTO.PersonDTO));
		
		return user;
	}
	
	public static UserDTO ConvertUserToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.Email = user.getEmail();
		userDTO.Password = user.getPassword();
		userDTO.UserName = user.getUserName();
		userDTO.UserGuid = user.getUserGuid();
		userDTO.PersonDTO = PersonTransformer.ConvertPersonToPersonDTO(user.getPerson());
		
		return userDTO;
	}

	public static UserDTO GetUserDTOByPublication(Publication publication)
	{
		UserDTO userDTO = new UserDTO();
		userDTO.Id = publication.getUser().getId();
		userDTO.UserName = publication.getUser().getUserName();
		userDTO.Email = publication.getUser().getEmail();		
		userDTO.Password = publication.getUser().getPassword();
		userDTO.UserGuid = publication.getUser().getUserGuid();
		
		userDTO.PersonDTO = PersonTransformer.GetPersonDTOByPublication(publication);
		
		return userDTO;
	}
	
	public static void LoadUserByUserDTO(UserDTO userDTO, User user) {
		user.setUserName(userDTO.UserName);
		user.setPassword(userDTO.Password);
		user.setEmail(userDTO.Email);
		user.setPerson(null);				//Se setea en null para no pisar la persona en el update por el bug de registros duplicados
	}
}
