package root.model;

@javax.persistence.Entity
public class Care extends Service {

	private int careTime;

	
	public int getCareTime() {
		return careTime;
	}

	public void setCareTime(int careTime) {
		this.careTime = careTime;
	}

}
