package root.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.DTO.CareDTO;
import root.DTO.PersonDTO;
import root.DTO.TransitDTO;
import root.DTO.TransportDTO;
import root.DTO.UserDTO;
import root.model.Care;
import root.model.Person;
import root.model.Transit;
import root.model.Transport;
import root.model.User;
import root.repository.PrestacionRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PrestacionController {

	@Autowired
	private PrestacionRepository prestacionRepository;
	
	@GetMapping("/allCareServices")
	public List<CareDTO> getAllCareServices() {
		
		List<Care> cares = prestacionRepository.findAllCareServices();
		List<CareDTO> caresDTO = new ArrayList<CareDTO>();
		
		for (Care care : cares) {
			caresDTO.add(ConvertCareToCareDTO(care));
		}
		
		return caresDTO;
	}
	
	private CareDTO ConvertCareToCareDTO(Care care)
	{
		CareDTO careDTO = new CareDTO();
		careDTO.Id = care.getId();
		careDTO.UserDTO = ConvertUserToUserDTO(care.getUser());
		
		careDTO.ServiceDescription = care.getDescription();
		careDTO.ServiceStatus = care.getServiceStatus();
		careDTO.UnidOfTime = care.getUnidOfTime();
		careDTO.CareTime = care.getCareTime();
		
		return careDTO;
	}
	
	private UserDTO ConvertUserToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.Email = user.getEmail();
		userDTO.Password = user.getPassword();
		userDTO.UserName = user.getUserName();
		userDTO.UserGuid = user.getUserGuid();
		userDTO.PersonDTO = ConvertPersonToPersonDTO(user.getPerson());
		
		return userDTO;
	}
	
	private PersonDTO ConvertPersonToPersonDTO(Person person) {
		PersonDTO personDTO = new PersonDTO();
		personDTO.Address = person.getAddress();
		personDTO.Location = person.getLocation();
		personDTO.Name = person.getName();
		personDTO.SurName = person.getSurName();
		personDTO.Telephone = person.getTelephone();
		
		return personDTO;
	}
	
	@GetMapping("/allTransitServices")
	public List<TransitDTO> getAllTransitServices() {
		
		List<Transit> listOfTransit = prestacionRepository.findAllTransitServices();
		List<TransitDTO> listOfTransitDTO = new ArrayList<TransitDTO>();
		
		for (Transit transit : listOfTransit) {
			listOfTransitDTO.add(ConvertTransitToTransitDTO(transit));
		}
		
		return listOfTransitDTO;
	}
	
	private TransitDTO ConvertTransitToTransitDTO(Transit transit)
	{
		TransitDTO transitDTO = new TransitDTO();
		transitDTO.Id = transit.getId();
		transitDTO.UserDTO = ConvertUserToUserDTO(transit.getUser());
		
		transitDTO.ServiceDescription = transit.getDescription();
		transitDTO.ServiceStatus = transit.getServiceStatus();
		transitDTO.UnidOfTime = transit.getUnidOfTime();
		transitDTO.TransitTime = transit.getTransitTime();
		
		return transitDTO;
	}

	@GetMapping("/allTransportServices")
	public List<TransportDTO> getAllTransportServices() {
		List<Transport> transports = prestacionRepository.findAllTransportServices();
		List<TransportDTO> transportsDTO = new ArrayList<TransportDTO>();
		
		for (Transport transport : transports) {
			transportsDTO.add(ConvertTransportToTransportDTO(transport));
		}
		
		return transportsDTO;
	}
	
	private TransportDTO ConvertTransportToTransportDTO(Transport transport)
	{
		TransportDTO transportDTO = new TransportDTO();
		transportDTO.Id = transport.getId();
		transportDTO.UserDTO = ConvertUserToUserDTO(transport.getUser());
		
		transportDTO.ServiceDescription = transport.getDescription();
		transportDTO.ServiceStatus = transport.getServiceStatus();
		transportDTO.UnidOfTime = transport.getUnidOfTime();
		transportDTO.ScheduleAvailable = transport.getScheduleAvailable();
		
		return transportDTO;
	}

	@GetMapping("/allUserCareServices/{id}")
	public List<CareDTO> getAllCareServicesByIdUser(@PathVariable(value = "id") Long idUser) {
		
		List<Care> cares = prestacionRepository.findAllCareServicesByIdUser(idUser);
		List<CareDTO> caresDTO = new ArrayList<CareDTO>();
		
		for (Care care : cares) {
			caresDTO.add(ConvertCareToCareDTO(care));
		}
		
		return caresDTO;
	}
	
	@GetMapping("/allUserTransitServices/{id}")
	public List<TransitDTO> getAllTransitServicesByIdUser(@PathVariable(value = "id") Long idUser) {
		
		List<Transit> listOfTransit = prestacionRepository.findAllTransitServicesByIdUser(idUser);
		List<TransitDTO> listOfTransitDTO = new ArrayList<TransitDTO>();
		
		for (Transit transit : listOfTransit) {
			listOfTransitDTO.add(ConvertTransitToTransitDTO(transit));
		}
		
		return listOfTransitDTO;
	}
	
	@GetMapping("/allUserTransportServices/{id}")
	public List<TransportDTO> getAllTransportServicesByIdUser(@PathVariable(value = "id") Long idUser) {
		
		List<Transport> transports = prestacionRepository.findAllTransportServicesByIdUser(idUser);
		List<TransportDTO> transportsDTO = new ArrayList<TransportDTO>();
		
		for (Transport transport : transports) {
			transportsDTO.add(ConvertTransportToTransportDTO(transport));
		}
		
		return transportsDTO;
	}
}
