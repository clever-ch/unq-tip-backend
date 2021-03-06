package root.DTO;

import root.constants.ServiceStatus;
import root.constants.TypeService;
import root.constants.UnidOfTime;
import root.controller.exceptions.ServiceIncompleteException;

public class TransportDTO {

	public long Id;
	public UserDTO UserDTO;
	
	public String ServiceDescription;
	public ServiceStatus ServiceStatus;
	public UnidOfTime UnidOfTime;
	public int ScheduleAvailable;
	public TypeService TypeService;
	
	public boolean isValidService() {
		return hasDescription() &
				hasUnidOfTime() &
				hasScheduleAvailable();
	}
	
	private boolean hasDescription() {
		return (this.ServiceDescription != "" & this.ServiceDescription != null) & 
				(this.minCharacterPass());
	}
	
	private boolean minCharacterPass() {
		if(this.ServiceDescription != null) {
			return this.ServiceDescription.length() > 50;
		} else throw new ServiceIncompleteException("Revisar formulario creacion de Servicio");
	}

	private boolean hasUnidOfTime() {
		return this.UnidOfTime != null;
	}

	private boolean hasScheduleAvailable() {
		return this.ScheduleAvailable <= 31;
	}
}
