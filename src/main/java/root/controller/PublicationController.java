package root.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.DTO.AnimalDTO;
import root.DTO.PersonDTO;
import root.DTO.PublicationDTO;
import root.DTO.UserDTO;
import root.constants.PublicationStatus;
import root.controller.exceptions.AnimalInvalidException;
import root.controller.exceptions.InvalidPublicationException;
import root.model.Animal;
import root.model.Person;
import root.model.Publication;
import root.model.User;
import root.repository.PublicationRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PublicationController {

	@Autowired
	private PublicationRepository publicationRepository;
	
	@GetMapping("/publications")
	public List<PublicationDTO> getAllPublications() {
		
		List<PublicationDTO> publicationsDTO = new ArrayList<PublicationDTO>();
		List<Publication> publications = publicationRepository.findAll();
		
		for (Publication publication : publications) {
			publicationsDTO.add(ConvertPublicationToPublicationDTO(publication));
		}
		
		//publications.stream().forEach(p -> publicationsDTO.add(ConvertPublicationToPublicationDTO(p)));
		
		return publicationsDTO;
	}
	
	private PublicationDTO ConvertPublicationToPublicationDTO(Publication publication)
	{
		PublicationDTO publicationDTO = new PublicationDTO();
		
		publicationDTO.Id = publication.getId();
		publicationDTO.PublicationAddress = publication.getPublicationAddress(); 
		publicationDTO.PublicationLocation = publication.getLocation();
		publicationDTO.PublicationType = publication.getPublicationType();
		publicationDTO.PublicationStatus = publication.getPublicationStatus();
		publicationDTO.PublicationDescription = publication.getPublicationDescription();
		publicationDTO.Photos = publication.getPhotos();
		
		publicationDTO.AnimalDTO = GetAnimalDTOByPublication(publication);
		publicationDTO.UserDTO = GetUserDTOByPublication(publication);
		
		return publicationDTO;
	}
	
	private AnimalDTO GetAnimalDTOByPublication(Publication publication)
	{
		AnimalDTO animalDTO = new AnimalDTO();
		animalDTO.Id = publication.getAnimal().getId();
		animalDTO.Breed = publication.getAnimal().getBreed();
		animalDTO.AnimalSize = publication.getAnimal().getSize();
		animalDTO.AnimalAge = publication.getAnimal().getAge();
		animalDTO.AnimalDescription = publication.getAnimal().getDescription();
		animalDTO.AnimalType = publication.getAnimal().getAnimalType();
		
		return animalDTO;
	}
	
	private UserDTO GetUserDTOByPublication(Publication publication)
	{
		UserDTO userDTO = new UserDTO();
		userDTO.Id = publication.getUser().getId();
		userDTO.UserName = publication.getUser().getUserName();
		userDTO.Email = publication.getUser().getEmail();		
		userDTO.Password = publication.getUser().getPassword();
		userDTO.UserGuid = publication.getUser().getUserGuid();
		
		userDTO.PersonDTO = GetPersonDTOByPublication(publication);
		
		return userDTO;
	}
	
	private PersonDTO GetPersonDTOByPublication(Publication publication)
	{
		PersonDTO personDTO = new PersonDTO();
		
		personDTO.Name = publication.getUser().getPerson().getName();
		personDTO.SurName = publication.getUser().getPerson().getSurName();
		personDTO.Telephone = publication.getUser().getPerson().getTelephone();
		personDTO.Address = publication.getUser().getPerson().getAddress();
		personDTO.Location = publication.getUser().getPerson().getLocation();
		
		return personDTO;
	}

	
	@GetMapping("/allPublicationsFound")
	public List<PublicationDTO> getAllPublicationsFound() {
		
		List<PublicationDTO> publicationsDTO = new ArrayList<PublicationDTO>();
		List<Publication> publications = publicationRepository.findAllPublicationsFound();
		
		for (Publication publication : publications) {
				publicationsDTO.add(ConvertPublicationToPublicationDTO(publication));
		}
		
		return publicationsDTO;
	}
	
	@GetMapping("/allPublicationsLost")
	public List<PublicationDTO> getAllPublicationsLost() {
		
		List<PublicationDTO> publicationsDTO = new ArrayList<PublicationDTO>();
		List<Publication> publications = publicationRepository.findAllPublicationsLost();
		
		for (Publication publication : publications) {
				publicationsDTO.add(ConvertPublicationToPublicationDTO(publication));
		}
		
		return publicationsDTO;
	}
	
	@PostMapping("/createPublication")
	public ResponseEntity<Publication> createPublication(@Valid @RequestBody PublicationDTO publicationDTO) {
		
		Publication publication = ConvertPublicationDTOToPublication(publicationDTO);
		
		if(publication.isValidPublication()) {
			publicationRepository.save(publication);
			return ResponseEntity.ok(publication);
		} else throw new InvalidPublicationException("Publicación incompleta");
	}

	private Publication ConvertPublicationDTOToPublication(PublicationDTO publicationDTO) {
		Publication publication = new Publication();
		
		publication.setLocation(publicationDTO.PublicationLocation);
		publication.setPhotos(publicationDTO.Photos);
		publication.setPublicationAddress(publicationDTO.PublicationAddress);
		publication.setPublicationDescription(publicationDTO.PublicationDescription);
		publication.setPublicationType(publicationDTO.PublicationType);
		
		publication.setPublicationStatus(PublicationStatus.ACTIVE);
		publication.setAnimal(ConvertAnimalDToToAnimal(publicationDTO.AnimalDTO));
		publication.setUser(ConvertUserDTOToUser(publicationDTO.UserDTO));
		
		return publication;
	}

	private User ConvertUserDTOToUser(UserDTO userDTO) {
		User user = new User();
		user.setEmail(userDTO.Email);
		user.setPassword(userDTO.Password);
		user.setUserName(userDTO.UserName);
		user.setUserGuid(userDTO.UserGuid);
		user.setPerson(ConvertPersonDTOToPerson(userDTO.PersonDTO));
		
		return user;
	}

	private Person ConvertPersonDTOToPerson(PersonDTO personDTO) {
		Person person = new Person();
		person.setAddress(personDTO.Address);
		person.setLocation(personDTO.Location);
		person.setName(personDTO.Name);
		person.setSurName(personDTO.SurName);
		person.setTelephone(personDTO.Telephone);
		
		return person;
	}

	private Animal ConvertAnimalDToToAnimal(AnimalDTO animalDTO) {
		Animal animal = new Animal();
		
		//Controlo que los campos importantes no lleguen null
		if(this.isValidAnimalDTO(animalDTO)) {
		animal.setAnimalType(animalDTO.AnimalType);
		animal.setBreed(animalDTO.Breed);
		animal.setAge(animalDTO.AnimalAge);
		} else throw new AnimalInvalidException();

		animal.setDescription(animalDTO.AnimalDescription);
		animal.setSize(animalDTO.AnimalSize);
		
		return animal;
	}

	private boolean isValidAnimalDTO(AnimalDTO animalDTO) {
		return (animalDTO.AnimalAge != "" & animalDTO.AnimalAge != null) &
				(animalDTO.Breed != "" & animalDTO.Breed != null) &
				(animalDTO.AnimalType != null);
	}
}
