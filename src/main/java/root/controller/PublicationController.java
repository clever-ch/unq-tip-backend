package root.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.DTO.AnimalDTO;
import root.DTO.PublicationDTO;
import root.DTO.UserDTO;
import root.constants.PublicationType;
import root.model.Publication;
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
		userDTO.AccountName = publication.getUser().getAccount().getName();
		userDTO.AccountSurName = publication.getUser().getAccount().getSurName();
		userDTO.AccountTelephone = publication.getUser().getAccount().getTelephone();
		userDTO.AccountAddress = publication.getUser().getAccount().getAddress();
		
		return userDTO;
	}

	
	@GetMapping("/allPublicationsFound")
	public List<PublicationDTO> getAllPublicationsFound() {
		
		List<PublicationDTO> publicationsDTO = new ArrayList<PublicationDTO>();
		List<Publication> publications = publicationRepository.findAll();
		
		for (Publication publication : publications) {
			
			if (publication.getPublicationType().equals(PublicationType.FOUND)) {
				publicationsDTO.add(ConvertPublicationToPublicationDTO(publication));
			}			
		}
		
		return publicationsDTO;
	}
	
	@GetMapping("/allPublicationsLost")
	public List<PublicationDTO> getAllPublicationsLost() {
		
		List<PublicationDTO> publicationsDTO = new ArrayList<PublicationDTO>();
		List<Publication> publications = publicationRepository.findAll();
		
		for (Publication publication : publications) {
			
			if (publication.getPublicationType().equals(PublicationType.LOST)) {
				publicationsDTO.add(ConvertPublicationToPublicationDTO(publication));
			}			
		}
		
		return publicationsDTO;
	}
}
