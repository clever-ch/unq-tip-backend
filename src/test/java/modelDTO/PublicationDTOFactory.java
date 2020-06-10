package modelDTO;

import root.DTO.AnimalDTO;
import root.DTO.PersonDTO;
import root.DTO.PublicationDTO;
import root.DTO.UserDTO;
import root.constants.AnimalType;
import root.constants.PublicationType;

public class PublicationDTOFactory {

	public static PublicationDTO anyPublicationDTO() {
		return new PublicationDTO();
	}
	
	public static PublicationDTO getPublicationDTOWithType(PublicationType type) {
		PublicationDTO publicationDTO = anyPublicationDTO();
		publicationDTO.PublicationType = type;
		
		return publicationDTO;
	}
	
	public static PublicationDTO createFullPublicationDTOWithType(PublicationType type) {
		
		AnimalDTO animalDTO = AnimalDTOFactory.createCompleteAnimal(AnimalType.BIRD, "", "", "", "");
		PersonDTO personDTO = PersonDTOFactory.createPersonComplete("", "", "", "", "");
		UserDTO userDTO = UserDTOFactory.createACompleteUser("", "", "", personDTO);

		PublicationDTO newPublication = new PublicationDTO();
        newPublication.PublicationType = type;
        newPublication.AnimalDTO = animalDTO; 
        newPublication.UserDTO = userDTO;
        
        return newPublication;
	}
}
