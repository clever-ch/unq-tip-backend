package root.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import root.constants.ServiceStatus;
import root.constants.UnidOfTime;
import root.utilities.Entity;

@MappedSuperclass
public abstract class Service extends Entity {
	
	@OneToOne
	private User user;
	
	@Enumerated(EnumType.STRING)
	private ServiceStatus serviceStatus;
	
	@OneToOne
	private Animal animal;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
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
