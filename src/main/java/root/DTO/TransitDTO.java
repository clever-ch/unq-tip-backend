package root.DTO;

import root.constants.ServiceStatus;
import root.constants.TypeService;
import root.constants.UnidOfTime;

public class TransitDTO {

	public long Id;
	public UserDTO UserDTO;
	
	public String ServiceDescription;
	public ServiceStatus ServiceStatus;
	public UnidOfTime UnidOfTime;
	public int TransitTime;
	public TypeService TypeService;
	
	public boolean isValidService() {
		return hasDescription() &
				hasUnidOfTime() &
				hasTransitTime();
	}
	
	private boolean hasDescription() {
		return this.ServiceDescription != "" & this.ServiceDescription != null;
	}

	private boolean hasUnidOfTime() {
		return this.UnidOfTime != null;
	}

	private boolean hasTransitTime() {
		return this.TransitTime != 0;
	}
}
