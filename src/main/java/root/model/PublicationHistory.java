package root.model;

import javax.persistence.OneToOne;
import root.utilities.Entity;

@javax.persistence.Entity
public class PublicationHistory extends Entity {

	@OneToOne
	private User user;
	
	@OneToOne
	private Publication publication;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
}
