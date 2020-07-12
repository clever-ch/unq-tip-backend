package root.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.DTO.CareDTO;
import root.DTO.TransitDTO;
import root.DTO.TransportDTO;
import root.model.Care;
import root.constants.ServiceStatus;
import root.model.Transit;
import root.model.Transport;
import root.repository.PrestacionRepository;
import root.transformers.CareTransformer;
import root.transformers.TransitTransformer;
import root.transformers.TransportTransformer;
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
	
	@DeleteMapping("/deleteTransitService/{id}")
	public Map<String, Boolean> deleteTransitServiceById(@PathVariable(value = "id") Long idService)
	{		
		Transit transitToActOrDes = prestacionRepository.findTransitServiceByIdService(idService);
		
		if(transitToActOrDes.getServiceStatus() == ServiceStatus.Activo) {
			transitToActOrDes.setServiceStatus(ServiceStatus.Inactivo);
			prestacionRepository.save(transitToActOrDes);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("disable", Boolean.TRUE);
			
			return response;
		} else {
			transitToActOrDes.setServiceStatus(ServiceStatus.Activo);
			prestacionRepository.save(transitToActOrDes);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("disable", Boolean.FALSE);
			
			return response;
		}
		
	}
	
	@DeleteMapping("/deleteTransportService/{id}")
	public Map<String, Boolean> deleteTransportServiceById(@PathVariable(value = "id") Long idService)
	{
		Transport TransportToActOrDes = prestacionRepository.findTransportServiceByIdService(idService);
		
		if(TransportToActOrDes.getServiceStatus() == ServiceStatus.Activo) {
			TransportToActOrDes.setServiceStatus(ServiceStatus.Inactivo);
			prestacionRepository.save(TransportToActOrDes);
		
			Map<String, Boolean> response = new HashMap<>();
			response.put("disable", Boolean.TRUE);
		
			return response;
		} else {
			TransportToActOrDes.setServiceStatus(ServiceStatus.Activo);
			prestacionRepository.save(TransportToActOrDes);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("disable", Boolean.FALSE);
			
			return response;
		}
	}
	
	@DeleteMapping("/deleteCareService/{id}")
	public Map<String, Boolean> deleteCareServiceById(@PathVariable(value = "id") Long idService)
	{
		Care CareToActOrDes = prestacionRepository.findCareServiceByIdService(idService);
		
		if(CareToActOrDes.getServiceStatus() == ServiceStatus.Activo) {
			CareToActOrDes.setServiceStatus(ServiceStatus.Inactivo);
			prestacionRepository.save(CareToActOrDes);
		
			Map<String, Boolean> response = new HashMap<>();
			response.put("disable", Boolean.TRUE);
		
			return response;
		} else {
			CareToActOrDes.setServiceStatus(ServiceStatus.Activo);
			prestacionRepository.save(CareToActOrDes);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("disable", Boolean.FALSE);
			
			return response;
		}
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
		
		if(serv.isValidService()) {
			
			Transit updateTransit = prestacionRepository.findTransitServiceByIdService(serv.Id);

			updateTransit.setDescription(serv.ServiceDescription);
			updateTransit.setUnidOfTime(serv.UnidOfTime);
			updateTransit.setTransitTime(serv.TransitTime);

			prestacionRepository.save(updateTransit);
			return ResponseEntity.ok(updateTransit);
			
		} else throw new ServiceIncompleteException("Servicio incompleto");

	}
	
	@PutMapping("/editService/Transport")
	public ResponseEntity<Transport> updateTransportService(@Valid @RequestBody TransportDTO serv){
		
		if(serv.isValidService()) {
			
			Transport updateTransport = prestacionRepository.findTransportServiceByIdService(serv.Id);

			updateTransport.setDescription(serv.ServiceDescription);
			updateTransport.setUnidOfTime(serv.UnidOfTime);
			updateTransport.setScheduleAvailable(serv.ScheduleAvailable);
			
			prestacionRepository.save(updateTransport);
			return ResponseEntity.ok(updateTransport);
			
		} else throw new ServiceIncompleteException("Servicio incompleto");
	}
	
	@PutMapping("/editService/Care")
	public ResponseEntity<Care> updateCareService(@Valid @RequestBody CareDTO serv){

		if(serv.isValidService()) {
			
			Care updateCare = prestacionRepository.findCareServiceByIdService(serv.Id);
			
			updateCare.setDescription(serv.ServiceDescription);
			updateCare.setUnidOfTime(serv.UnidOfTime);
			updateCare.setCareTime(serv.CareTime);
			
			prestacionRepository.save(updateCare);
			return ResponseEntity.ok(updateCare);
			
		} else throw new ServiceIncompleteException("Servicio incompleto");
	}
	
	@PostMapping("/createTransitService")
	public ResponseEntity<Transit> createTransitService(@Valid @RequestBody TransitDTO transitDTO) {
		
		//Primero deben ir las validaciones sobre el DTO
		if(transitDTO.isValidService()) {
		
			long idUsuario = transitDTO.UserDTO.Id;
			Transit transit = TransitTransformer.ConvertTransitDTOToTransit(transitDTO);
			transit.setServiceStatus(ServiceStatus.Activo);
		
			SaveOrUpdateTransitService(idUsuario, transit);
		
			return ResponseEntity.ok(transit);
			
		} else throw new ServiceIncompleteException("Revisar formulario creacion de Servicio");
	}

	private void SaveOrUpdateTransitService(long idUsuario, Transit transit) {
		prestacionRepository.save(transit);
		Transit lastTransit = prestacionRepository.getLastTransitServiceCreated();
		prestacionRepository.updateIdUserInTransitService(idUsuario, lastTransit.getId());
	}
	
	@PostMapping("/createTransportService")
	public ResponseEntity<Transport> createTransportService(@Valid @RequestBody TransportDTO transportDTO) {
		
		//Primero deben ir las validaciones sobre el DTO
		if(transportDTO.isValidService()) {
		
			long idUsuario = transportDTO.UserDTO.Id;
			Transport transport = TransportTransformer.ConvertTransportDTOToTransport(transportDTO);
			transport.setServiceStatus(ServiceStatus.Activo);
			
			SaveOrUpdateTransportService(idUsuario, transport);
		
			return ResponseEntity.ok(transport);
			
		} else throw new ServiceIncompleteException("Revisar formulario creacion de Servicio");
	}

	private void SaveOrUpdateTransportService(long idUsuario, Transport transport) {
		prestacionRepository.save(transport);
		Transport lastTransport = prestacionRepository.getLastTransportServiceCreated();
		prestacionRepository.updateIdUserInTransportService(idUsuario, lastTransport.getId());
	}
	
	@PostMapping("/createCareService")
	public ResponseEntity<Care> createCareService(@Valid @RequestBody CareDTO careDTO) {
		
		//Primero deben ir las validaciones sobre el DTO
		if(careDTO.isValidService()) {
		
			long idUsuario = careDTO.UserDTO.Id;
			Care care = CareTransformer.ConvertCareDTOToCare(careDTO);
			care.setServiceStatus(ServiceStatus.Activo);
		
			SaveOrUpdateCareService(idUsuario, care);
		
			return ResponseEntity.ok(care);
			
		} else throw new ServiceIncompleteException("Revisar formulario creacion de Servicio");
		
	}

	private void SaveOrUpdateCareService(long idUsuario, Care care) {
		prestacionRepository.save(care);
		Care lastCare = prestacionRepository.getLastCareServiceCreated();
		prestacionRepository.updateIdUserInCareService(idUsuario, lastCare.getId());
	}

}
