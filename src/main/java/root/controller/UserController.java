package root.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import root.DTO.PersonDTO;
import root.DTO.UserDTO;
import root.model.Person;
import root.model.User;
import root.repository.UserRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/createUser")
	public User createUser(@Valid @RequestBody UserDTO userDTO) {

		User user = ConvertUserDTOToUser(userDTO);

		return userRepository.save(user);
	}

	private User ConvertUserDTOToUser(UserDTO userDTO) {
		User user = new User();
		
		user.setUserName(userDTO.UserName);
		user.setPassword(userDTO.Password);
		user.setEmail(userDTO.Email);
		user.setUserGuid(UUID.randomUUID().toString());
		user.setPerson(ConvertPersonDTOToPerson(userDTO.PersonDTO));
		
		return user;
	}

	private Person ConvertPersonDTOToPerson(PersonDTO personDTO) {
		Person person = new Person();
		
		person.setName(personDTO.Name);
		person.setSurName(personDTO.SurName);
		person.setTelephone(personDTO.Telephone);
		person.setAddress(personDTO.Address);
		person.setLocation(personDTO.Location);
		
		return person;
	}
	
}
