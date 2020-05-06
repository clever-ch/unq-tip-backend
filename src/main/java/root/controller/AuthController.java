package root.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.DTO.LoginDTO;
import root.DTO.PersonDTO;
import root.DTO.UserDTO;
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
	public LoginDTO login(@Valid @RequestBody LoginDTO loginDTO)
	{
		System.out.println("Llego al back con user y password:");
		System.out.println(loginDTO.Username + " " + loginDTO.Password);
		
		String userIngresado = loginDTO.Username;
		String pssIngresado = loginDTO.Password;
		UserDTO userDTO = new UserDTO();
		
		List<User> usuarios = userRepository.findAll();
		
		for (User user : usuarios) {
			
			if (user.getUserName().equals(userIngresado) && user.getPassword().equals(pssIngresado)) {
				userDTO = ConvertUserToUserDTO(user);
			}
			else
			{
				//Lanzar excepcion
			}
		}
		
		System.out.println("Encuentro el usuario con Id:");
		System.out.println(userDTO.Id);

		return loginDTO;
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
