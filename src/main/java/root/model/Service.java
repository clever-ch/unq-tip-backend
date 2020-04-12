package root.model;

import root.constants.ServiceStatus;
import root.constants.UnidOfTime;
import root.utilities.Entity;

public abstract class Service extends Entity {
	
	private User user;
	private ServiceStatus serviceStatus;
	private Animal animal;
	private String description;
	private UnidOfTime unidOfTime;

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ServiceStatus getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(ServiceStatus serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UnidOfTime getUnidOfTime() {
		return unidOfTime;
	}

	public void setUnidOfTime(UnidOfTime unidOfTime) {
		this.unidOfTime = unidOfTime;
	}  
}
