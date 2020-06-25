package root.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.DTO.CareDTO;
import root.DTO.PersonDTO;
import root.DTO.TransitDTO;
import root.DTO.TransportDTO;
import root.DTO.UserDTO;
import root.constants.TypeService;
import root.model.Care;
import root.model.Person;
import root.model.Service;
import root.model.Transit;
import root.model.Transport;
import root.model.User;
import root.repository.PrestacionRepository;
import root.transformers.CareTransformer;
import root.transformers.TransitTransformer;
import root.transformers.TransportTransformer;
import root.transformers.UserTransformer;
import root.controller.exceptions.ServiceIncompleteException;

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
			caresDTO.add(CareTransformer.ConvertCareToCareDTO(care));
		}
		
		return caresDTO;
	}
	
	@GetMapping("/allTransitServices")
	public List<TransitDTO> getAllTransitServices() {
		
		List<Transit> listOfTransit = prestacionRepository.findAllTransitServices();
		List<TransitDTO> listOfTransitDTO = new ArrayList<TransitDTO>();
		
		for (Transit transit : listOfTransit) {
			listOfTransitDTO.add(TransitTransformer.ConvertTransitToTransitDTO(transit));
		}
		
		return listOfTransitDTO;
	}

	@GetMapping("/allTransportServices")
	public List<TransportDTO> getAllTransportServices() {
		List<Transport> transports = prestacionRepository.findAllTransportServices();
		List<TransportDTO> transportsDTO = new ArrayList<TransportDTO>();
		
		for (Transport transport : transports) {
			transportsDTO.add(TransportTransformer.ConvertTransportToTransportDTO(transport));
		}
		
		return transportsDTO;
	}

	@GetMapping("/allUserCareServices/{id}")
	public List<CareDTO> getAllCareServicesByIdUser(@PathVariable(value = "id") Long idUser) {
		
		List<Care> cares = prestacionRepository.findAllCareServicesByIdUser(idUser);
		List<CareDTO> caresDTO = new ArrayList<CareDTO>();
		
		for (Care care : cares) {
			caresDTO.add(CareTransformer.ConvertCareToCareDTO(care));
		}
		
		return caresDTO;
	}
	
	@GetMapping("/allUserTransitServices/{id}")
	public List<TransitDTO> getAllTransitServicesByIdUser(@PathVariable(value = "id") Long idUser) {
		
		List<Transit> listOfTransit = prestacionRepository.findAllTransitServicesByIdUser(idUser);
		List<TransitDTO> listOfTransitDTO = new ArrayList<TransitDTO>();
		
		for (Transit transit : listOfTransit) {
			listOfTransitDTO.add(TransitTransformer.ConvertTransitToTransitDTO(transit));
		}
		
		return listOfTransitDTO;
	}
	
	@GetMapping("/allUserTransportServices/{id}")
	public List<TransportDTO> getAllTransportServicesByIdUser(@PathVariable(value = "id") Long idUser) {
		
		List<Transport> transports = prestacionRepository.findAllTransportServicesByIdUser(idUser);
		List<TransportDTO> transportsDTO = new ArrayList<TransportDTO>();
		
		for (Transport transport : transports) {
			transportsDTO.add(TransportTransformer.ConvertTransportToTransportDTO(transport));
		}
		
		return transportsDTO;
	}
	
	@GetMapping("/service/Transit/{id}")
	public TransitDTO getTransitServiceByIdAndTypeService(@PathVariable(value = "id") Long idTransit) {
		
		Transit serviceTransit = prestacionRepository.findTransitServiceByIdService(idTransit);
		TransitDTO servTransitDTO = TransitTransformer.ConvertTransitToTransitDTO(serviceTransit);

		return servTransitDTO;
	}
	
	@GetMapping("/service/Transport/{id}")
	public TransportDTO getTransportServiceByIdAndTypeService(@PathVariable(value = "id") Long idTransport) {
		
		Transport serviceTransport = prestacionRepository.findTransportServiceByIdService(idTransport);
		TransportDTO servTransportDTO = TransportTransformer.ConvertTransportToTransportDTO(serviceTransport);

		return servTransportDTO;
	}
	
	
	@GetMapping("/service/Care/{id}")
	public CareDTO getCareServiceByIdAndTypeService(@PathVariable(value = "id") Long idCare) {
		
		Care serviceCare = prestacionRepository.findCareServiceByIdService(idCare);
		CareDTO servCareDTO = CareTransformer.ConvertCareToCareDTO(serviceCare);

		return servCareDTO;
	}
	
	@PutMapping("/editService/Transit")
	public ResponseEntity<Transit> updateTransitService(@Valid @RequestBody TransitDTO serv) {
		
		Transit updateTransit = prestacionRepository.findTransitServiceByIdService(serv.Id);
		
		if(serv.isValidService()) {

			updateTransit.setDescription(serv.ServiceDescription);
			updateTransit.setUnidOfTime(serv.UnidOfTime);
			updateTransit.setTransitTime(serv.TransitTime);

			prestacionRepository.save(updateTransit);
			return ResponseEntity.ok(updateTransit);
			
		} else throw new ServiceIncompleteException("Servicio incompleto");

	}
	
	@PutMapping("/editService/Transport")
	public ResponseEntity<Transport> updateTransportService(@Valid @RequestBody TransportDTO serv){
		

		Transport updateTransport = prestacionRepository.findTransportServiceByIdService(serv.Id);

		if(serv.isValidService()) {

			updateTransport.setDescription(serv.ServiceDescription);
			updateTransport.setUnidOfTime(serv.UnidOfTime);
			updateTransport.setScheduleAvailable(serv.ScheduleAvailable);
			
			prestacionRepository.save(updateTransport);
			return ResponseEntity.ok(updateTransport);
			
		} else throw new ServiceIncompleteException("Servicio incompleto");
	}
	
	@PutMapping("/editService/Care")
	public ResponseEntity<Care> updateCareService(@Valid @RequestBody CareDTO serv){

		Care updateCare = prestacionRepository.findCareServiceByIdService(serv.Id);
		
		if(serv.isValidService()) {

			updateCare.setDescription(serv.ServiceDescription);
			updateCare.setUnidOfTime(serv.UnidOfTime);
			updateCare.setCareTime(serv.CareTime);
			
			prestacionRepository.save(updateCare);
			return ResponseEntity.ok(updateCare);
			
		} else throw new ServiceIncompleteException("Servicio incompleto");
	}
}
