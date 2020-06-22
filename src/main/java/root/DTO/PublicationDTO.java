package root.DTO;

import java.util.List;
import root.constants.PublicationType;
import root.constants.PublicationStatus;

public class PublicationDTO {

	public long Id;
	
	public AnimalDTO AnimalDTO;
	public UserDTO UserDTO;
	
	public String PublicationAddress;
	public String PublicationLocation;
	public PublicationType PublicationType;
	public PublicationStatus PublicationStatus;
	public String PublicationDescription;

	public List<String> Photos;
	
    public boolean isValidPublicationDTO() {
        return !isEmptyAnimal()
                & !isEmptyUser()
                & hasAPublicationType()
                & !isEmptyPublicationAddress()
                & !isEmptyPublicationDescription()
                & !isEmptyPhotos();
    }
    
    private boolean isEmptyAnimal() {
        return this.AnimalDTO == null;
    }

    private boolean isEmptyUser() {
        return this.UserDTO == null;
    }

    private boolean hasAPublicationType(){
        return this.PublicationType!= null;
    }

    private boolean isEmptyPublicationAddress() {
        return this.PublicationAddress == "" | this.PublicationAddress == null;
    }

    private boolean isEmptyPublicationDescription() {
        return this.PublicationDescription == "";
    }
    
    private boolean isEmptyPhotos() {
    	return this.Photos.size() == 0;
    }
}
