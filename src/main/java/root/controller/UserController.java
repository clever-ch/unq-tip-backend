package root.controller;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import root.DTO.PersonDTO;
import root.DTO.UserDTO;
import root.controller.exceptions.EmailAlreadyCreatedException;
import root.controller.exceptions.EmailInvalidException;
import root.controller.exceptions.UserAlreadyCreatedExceptions;
import root.exceptions.InvalidUserException;
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
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) throws EmailAlreadyCreatedException, UserAlreadyCreatedExceptions {

		User user = ConvertUserDTOToUser(userDTO);
		
		List<User> users = userRepository.findAll();
		
		for (User us : users) {
			//Controlo que el userName no este creado ya.
			if(us.getUserName().equals(user.getUserName())) throw new UserAlreadyCreatedExceptions();
			
			//Controlo que no haya otro usuario con el mismo mail.
			if(us.getEmail().equals(user.getEmail())) throw new EmailAlreadyCreatedException();
		}	
		
		//Controlo que todos los campos  esten completos y no posean null o string vacios.
		if (user.isValidUser()){ 	
			userRepository.save(user);
			return ResponseEntity.ok(user);
		} else throw new InvalidUserException("Usuario incompleto");
	}
	
	//Metodo para validar que el mail este bien escrito
	public boolean isValidEmail(String email) throws EmailInvalidException {
		// Patrón para validar el email
				Pattern pattern = Pattern
						.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
				Matcher mather = pattern.matcher(email);

				return mather.find();
	}
	
	private User ConvertUserDTOToUser(UserDTO userDTO) {
		User user = new User();
		
		user.setUserName(userDTO.UserName);
		user.setPassword(userDTO.Password);
		
		//Controlo que el mail sea valido antes de hacer el save
		if(isValidEmail(userDTO.Email)) {
			user.setEmail(userDTO.Email);
		} else throw new EmailInvalidException();
		
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
