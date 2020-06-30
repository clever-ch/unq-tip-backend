package root.transformers;

import root.DTO.CareDTO;
import root.model.Care;

public class CareTransformer {
	
	public static CareDTO ConvertCareToCareDTO(Care care)
	{
		CareDTO careDTO = new CareDTO();
		careDTO.Id = care.getId();
		careDTO.UserDTO = UserTransformer.ConvertUserToUserDTO(care.getUser());
		
		careDTO.TypeService = care.getTypeService();
		careDTO.ServiceDescription = care.getDescription();
		careDTO.ServiceStatus = care.getServiceStatus();
		careDTO.UnidOfTime = care.getUnidOfTime();
		careDTO.CareTime = care.getCareTime();
		return careDTO;
	}
	
	public static Care ConvertCareDTOToCare(CareDTO careDTO)
	{
		Care care = new Care();
		//care.setUser(UserTransformer.ConvertUserDTOToUser(careDTO.UserDTO));
		
		care.setTypeService(careDTO.TypeService);
		care.setDescription(careDTO.ServiceDescription);
		care.setServiceStatus(careDTO.ServiceStatus);
		care.setUnidOfTime(careDTO.UnidOfTime);
		care.setCareTime(careDTO.CareTime);
		
		return care;
	}
}
