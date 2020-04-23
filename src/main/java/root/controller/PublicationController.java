package root.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.DTO.PublicationDTO;
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
		publicationDTO.Breed = publication.getAnimal().getBreed();
		publicationDTO.Size = publication.getAnimal().getSize();
		publicationDTO.Age = publication.getAnimal().getAge();
		publicationDTO.Description = publication.getAnimal().getDescription();
		publicationDTO.AnimalType = publication.getAnimal().getAnimalType().ordinal();
		
		publicationDTO.UserName = publication.getUser().getUserName();
		publicationDTO.Email = publication.getUser().getEmail();
		
		publicationDTO.AccountName = publication.getUser().getAccount().getName();
		publicationDTO.AccountSurName = publication.getUser().getAccount().getSurName();
		publicationDTO.AccountTelephone = publication.getUser().getAccount().getTelephone();
		
		publicationDTO.Location = publication.getLocation();
		publicationDTO.PublicationType = publication.getPublicationType().ordinal();
		publicationDTO.PublicationStatus = publication.getPublicationStatus().ordinal();
		publicationDTO.Adrees = publication.getAddress();
		publicationDTO.Specification = publication.getSpecification();
		publicationDTO.Photos = publication.getPhotos();
		
		return publicationDTO;
	}
}
