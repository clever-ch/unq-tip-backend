package root.model;

import javax.persistence.OneToOne;
import root.utilities.Entity;

@javax.persistence.Entity
public class User extends Entity {
	
	private String email;
	private String userName;
	
	@OneToOne
	private Account account;
	
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

	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

}
