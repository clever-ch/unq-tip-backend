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
}
