package root.model;

@javax.persistence.Entity
public class Transport extends Service {

	private int scheduleAvailable;

	public int getScheduleAvailable() {
		return scheduleAvailable;
	}

	public void setScheduleAvailable(int scheduleAvailable) {
		this.scheduleAvailable = scheduleAvailable;
	}
}
