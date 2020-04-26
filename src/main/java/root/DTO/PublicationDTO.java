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
}
