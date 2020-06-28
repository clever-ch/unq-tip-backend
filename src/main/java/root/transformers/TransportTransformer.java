package root.transformers;

import root.DTO.TransportDTO;
import root.model.Transport;

public class TransportTransformer {
	
	public static TransportDTO ConvertTransportToTransportDTO(Transport transport)
	{
		TransportDTO transportDTO = new TransportDTO();
		transportDTO.Id = transport.getId();
		transportDTO.UserDTO = UserTransformer.ConvertUserToUserDTO(transport.getUser());
		
		transportDTO.TypeService = transport.getTypeService();
		transportDTO.ServiceDescription = transport.getDescription();
		transportDTO.ServiceStatus = transport.getServiceStatus();
		transportDTO.UnidOfTime = transport.getUnidOfTime();
		transportDTO.ScheduleAvailable = transport.getScheduleAvailable();
		
		return transportDTO;
	}
	
	public static Transport ConvertTransportDTOToTransport(TransportDTO transportDTO)
	{
		Transport transport = new Transport();
		//transport.setUser(UserTransformer.ConvertUserDTOToUser(transportDTO.UserDTO));
		
		transport.setTypeService(transportDTO.TypeService);
		transport.setDescription(transportDTO.ServiceDescription);
		transport.setServiceStatus(transportDTO.ServiceStatus);
		transport.setUnidOfTime(transportDTO.UnidOfTime);
		transport.setScheduleAvailable(transportDTO.ScheduleAvailable);
		
		return transport;
	}
}
