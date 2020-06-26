package root.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.DTO.AnimalDTO;
import root.DTO.PublicationDTO;
import root.constants.PublicationStatus;
import root.controller.exceptions.AnimalInvalidException;
import root.controller.exceptions.InvalidPublicationException;
import root.controller.exceptions.WithoutPublicationsException;
import root.model.Publication;
import root.repository.PublicationRepository;
import root.transformers.PublicationTransformer;


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
			publicationsDTO.add(PublicationTransformer.ConvertPublicationToPublicationDTO(publication));
		}
		
		//publications.stream().forEach(p -> publicationsDTO.add(ConvertPublicationToPublicationDTO(p)));
		
		return publicationsDTO;
	}

	
	@GetMapping("/allPublicationsFound")
	public List<PublicationDTO> getAllPublicationsFound() {
		
		List<PublicationDTO> publicationsDTO = new ArrayList<PublicationDTO>();
		List<Publication> publications = publicationRepository.findAllPublicationsFound();
		
		for (Publication publication : publications) {
				publicationsDTO.add(PublicationTransformer.ConvertPublicationToPublicationDTO(publication));
		}
		
		return publicationsDTO;
	}
	
	@GetMapping("/allPublicationsLost")
	public List<PublicationDTO> getAllPublicationsLost() {
		
		List<PublicationDTO> publicationsDTO = new ArrayList<PublicationDTO>();
		List<Publication> publications = publicationRepository.findAllPublicationsLost();
		
		for (Publication publication : publications) {
				publicationsDTO.add(PublicationTransformer.ConvertPublicationToPublicationDTO(publication));
		}
		
		return publicationsDTO;
	}
	
	@PostMapping("/createPublication")
	public ResponseEntity<Publication> createPublication(@Valid @RequestBody PublicationDTO publicationDTO) {
		
		ValidateAnimalDTO(publicationDTO.AnimalDTO);
		
		if(publicationDTO.isValidPublicationDTO()) {
			
			long idUsuario = publicationDTO.UserDTO.Id;
			Publication publication = PublicationTransformer.ConvertPublicationDTOToPublication(publicationDTO);
			publication.setPublicationStatus(PublicationStatus.ACTIVE);
			
			SaveOrUpdatePublication(idUsuario, publication);
			
			return ResponseEntity.ok(publication);
		} else throw new InvalidPublicationException("Publicación incompleta");
	}

	private void SaveOrUpdatePublication(long idUsuario, Publication publication) {
		publicationRepository.save(publication);
		Publication lastPublication = publicationRepository.getLastPublicationCreated();
		publicationRepository.updateIdUserInPublication(idUsuario, lastPublication.getId());
	}
	
	private void ValidateAnimalDTO(AnimalDTO animalDTO) {
		if(!this.isValidAnimalDTO(animalDTO))
			throw new AnimalInvalidException();
	}

	private boolean isValidAnimalDTO(AnimalDTO animalDTO) {
		return (animalDTO.AnimalAge != "" & animalDTO.AnimalAge != null) &
				(animalDTO.Breed != "" & animalDTO.Breed != null) &
				(animalDTO.AnimalType != null);
	}
	
	@GetMapping("/allUserPublicationsLost/{id}")
	public List<PublicationDTO> GetAllPublicationsLostByIdUser(@PathVariable(value = "id") Long idUser) {
		
		List<PublicationDTO> publicationsDTO = new ArrayList<PublicationDTO>();
		List<Publication> publications = publicationRepository.findAllPublicationsLostIdUser(idUser);
		
		if(publications.size() != 0)
		{
			for (Publication publication : publications) {
				publicationsDTO.add(PublicationTransformer.ConvertPublicationToPublicationDTO(publication));
				}
			return publicationsDTO;
		} else throw new WithoutPublicationsException("No hay publicaciones en mascotas perdidas");
	 }

	
	@GetMapping("/allUserPublicationsFound/{id}")
	public List<PublicationDTO> GetAllPublicationsFoundByIdUser(@PathVariable(value = "id") Long idUser) {
		
		List<PublicationDTO> publicationsDTO = new ArrayList<PublicationDTO>();
		List<Publication> publications = publicationRepository.findAllPublicationsFoundByIdUser(idUser);
		
		if(publications.size() != 0)
		{
			for (Publication publication : publications) {
				publicationsDTO.add(PublicationTransformer.ConvertPublicationToPublicationDTO(publication));
				}
			return publicationsDTO;
		} else throw new WithoutPublicationsException("No hay publicaciones en mascotas encontradas");
	 }
}

