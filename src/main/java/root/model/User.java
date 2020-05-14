package root.model;

import javax.persistence.OneToOne;
import root.utilities.Entity;

@javax.persistence.Entity
public class User extends Entity {
	
	private String email;
	private String password;
	private String userGuid;
	private String userName;
	
	
	@OneToOne
	private Person person;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Person getPerson() {
		return person;
	}
  
	public void setPerson(Person person) {
		this.person = person;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserGuid() {
		return userGuid;
	}

	public void setUserGuid(String userGuid) {
		this.userGuid = userGuid;
	}
}
