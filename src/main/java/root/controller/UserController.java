package root.controller;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.DTO.UserDTO;
import root.controller.exceptions.EmailAlreadyCreatedException;
import root.controller.exceptions.EmailInvalidException;
import root.controller.exceptions.UserAlreadyCreatedExceptions;
import root.exceptions.InvalidUserException;
import root.model.Person;
import root.model.User;
import root.repository.PersonRepository;
import root.repository.UserRepository;
import root.transformers.PersonTransformer;
import root.transformers.UserTransformer;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) throws EmailAlreadyCreatedException, UserAlreadyCreatedExceptions {

		ValidateEmail(userDTO.Email);
		
		List<User> users = userRepository.findAll();
		
		for (User us : users) {
			if(us.getUserName().equals(userDTO.UserName)) throw new UserAlreadyCreatedExceptions();

			if(us.getEmail().equals(userDTO.Email)) throw new EmailAlreadyCreatedException();
		}
		
		if (userDTO.isValidUserDTO()){
			
			User user = UserTransformer.ConvertUserDTOToUser(userDTO);
			user.setUserGuid(UUID.randomUUID().toString());
			userRepository.save(user);
			
			return ResponseEntity.ok(user);
		} else throw new InvalidUserException("Usuario incompleto");
	}
	
	private boolean isValidEmail(String email) throws EmailInvalidException {
		// Patrón para validar el email
				Pattern pattern = Pattern
						.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
				Matcher mather = pattern.matcher(email);

				return mather.find();
	}
	
	@PutMapping("/editProfile")
	public ResponseEntity<User> editProfile(@Valid @RequestBody UserDTO userDTO) {
		
		ValidateEmail(userDTO.Email);

		if (userDTO.isValidUserDTO()){
			
			User user = userRepository.findUserByUserGuid(userDTO.UserGuid);
			UserTransformer.LoadUserByUserDTO(userDTO, user);			
			SaveOrUpdateUser(userDTO, user);
			
			return ResponseEntity.ok(user);
		} else throw new InvalidUserException("Usuario incompleto");
	}

	private void ValidateEmail(String eMail) {
		if(!isValidEmail(eMail))
			throw new EmailInvalidException();
	}

	private void SaveOrUpdateUser(UserDTO userDTO, User user) {
		
		personRepository.updatePersonWithParameters(userDTO.PersonDTO.Address, userDTO.PersonDTO.Location, userDTO.PersonDTO.Name,
														userDTO.PersonDTO.SurName, userDTO.PersonDTO.Telephone, userDTO.PersonDTO.Id);
		
		userRepository.save(user);
		userRepository.updateIdPersonInUser(userDTO.PersonDTO.Id, user.getId());
	}
	
}
