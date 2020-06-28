package root.transformers;

import root.DTO.TransitDTO;
import root.model.Transit;

public class TransitTransformer {
	
	public static TransitDTO ConvertTransitToTransitDTO(Transit transit)
	{
		TransitDTO transitDTO = new TransitDTO();
		transitDTO.Id = transit.getId();
		transitDTO.UserDTO = UserTransformer.ConvertUserToUserDTO(transit.getUser());
		
		transitDTO.TypeService = transit.getTypeService();
		transitDTO.ServiceDescription = transit.getDescription();
		transitDTO.ServiceStatus = transit.getServiceStatus();
		transitDTO.UnidOfTime = transit.getUnidOfTime();
		transitDTO.TransitTime = transit.getTransitTime();
		
		return transitDTO;
	}
	
	public static Transit ConvertTransitDTOToTransit(TransitDTO transitDTO)
	{
		Transit transit = new Transit();
		//transit.setUser(UserTransformer.ConvertUserDTOToUser(transitDTO.UserDTO));
		
		transit.setTypeService(transitDTO.TypeService);
		transit.setDescription(transitDTO.ServiceDescription);
		transit.setServiceStatus(transitDTO.ServiceStatus);
		transit.setUnidOfTime(transitDTO.UnidOfTime);
		transit.setTransitTime(transitDTO.TransitTime);
		
		return transit;
	}
}
