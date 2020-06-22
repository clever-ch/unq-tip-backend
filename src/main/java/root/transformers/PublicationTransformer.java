package root.transformers;

import root.DTO.PublicationDTO;
import root.model.Publication;

public class PublicationTransformer {
	
	public static Publication ConvertPublicationDTOToPublication(PublicationDTO publicationDTO) {
		Publication publication = new Publication();
		
		publication.setLocation(publicationDTO.PublicationLocation);
		publication.setPhotos(publicationDTO.Photos);
		publication.setPublicationAddress(publicationDTO.PublicationAddress);
		publication.setPublicationDescription(publicationDTO.PublicationDescription);
		publication.setPublicationType(publicationDTO.PublicationType);		
		publication.setPublicationStatus(publicationDTO.PublicationStatus);
		publication.setAnimal(AnimalTransformer.ConvertAnimalDToToAnimal(publicationDTO.AnimalDTO));
		
		//No seteo el usuario para que quede en null por el bug donde se duplican registros
		//publication.setUser(ConvertUserDTOToUser(publicationDTO.UserDTO));
		
		return publication;
	}
	
	public static PublicationDTO ConvertPublicationToPublicationDTO(Publication publication)
	{
		PublicationDTO publicationDTO = new PublicationDTO();
		
		publicationDTO.Id = publication.getId();
		publicationDTO.PublicationAddress = publication.getPublicationAddress(); 
		publicationDTO.PublicationLocation = publication.getLocation();
		publicationDTO.PublicationType = publication.getPublicationType();
		publicationDTO.PublicationStatus = publication.getPublicationStatus();
		publicationDTO.PublicationDescription = publication.getPublicationDescription();
		publicationDTO.Photos = publication.getPhotos();
		
		publicationDTO.AnimalDTO = AnimalTransformer.GetAnimalDTOByPublication(publication);
		publicationDTO.UserDTO = UserTransformer.GetUserDTOByPublication(publication);
		
		return publicationDTO;
	}
}
