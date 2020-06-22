package root.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import root.constants.ServiceStatus;
import root.constants.TypeService;
import root.constants.UnidOfTime;
import root.utilities.Entity;

@MappedSuperclass
public abstract class Service extends Entity {
	
	@OneToOne
	private User user;
	
	@Column(nullable=false)
	private ServiceStatus serviceStatus;
	
	private String description;
	
	@Column(nullable=false)
	private UnidOfTime unidOfTime;
	
	@Column(nullable=false)
	private TypeService typeService;

	
	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

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
