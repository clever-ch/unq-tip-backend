package root.DTO;

import root.constants.ServiceStatus;
import root.constants.UnidOfTime;

public class TransportDTO {

	public long Id;
	public UserDTO UserDTO;
	
	public String ServiceDescription;
	public ServiceStatus ServiceStatus;
	public UnidOfTime UnidOfTime;
	public int ScheduleAvailable;
}
