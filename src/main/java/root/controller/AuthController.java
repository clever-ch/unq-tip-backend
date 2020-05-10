package root.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.DTO.LoginDTO;
import root.DTO.PersonDTO;
import root.DTO.UserDTO;
import root.exceptions.InvalidUserException;
import root.model.Person;
import root.model.User;
import root.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class AuthController {

	@Autowired
	private UserRepository userRepository;

	
	@PostMapping("/log-in")
	public UserDTO login(@Valid @RequestBody LoginDTO loginDTO) throws InvalidUserException
	{
		User user = userRepository.findByUserNameAndPassword(loginDTO.Username, loginDTO.Password);
		
		if (user != null) {
			return ConvertUserToUserDTO(user);
		}
		else
		{
			throw new InvalidUserException("El usuario ingresado no existe");
		}
	}
	
	private PersonDTO ConvertPersonToPersonDTO(Person person)
	{
		PersonDTO personDTO = new PersonDTO();
		personDTO.Id = person.getId();
		
		personDTO.Address = person.getAddress();
		personDTO.Location = person.getLocation();
		personDTO.Name = person.getName();
		personDTO.SurName = person.getSurName();
		personDTO.Telephone = person.getTelephone();
		
		return personDTO;
	}
	
	private UserDTO ConvertUserToUserDTO(User user)
	{
		UserDTO userDTO = new UserDTO();
		userDTO.Id = user.getId();
		
		userDTO.Email = user.getEmail();
		userDTO.UserName = user.getUserName();
		userDTO.Password = user.getPassword();
		userDTO.UserGuid = user.getUserGuid();
		userDTO.PersonDTO = ConvertPersonToPersonDTO(user.getPerson());
		
		return userDTO;
	}
}
