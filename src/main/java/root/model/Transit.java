package root.model;

@javax.persistence.Entity
public class Transit extends Service {

	private int transitTime;

	
	public int getTransitTime() {
		return transitTime;
	}

	public void setTransitTime(int transitTime) {
		this.transitTime = transitTime;
	}

}
