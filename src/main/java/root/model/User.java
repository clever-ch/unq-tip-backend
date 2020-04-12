package root.model;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import root.constants.UserProfile;
import root.utilities.Entity;

@javax.persistence.Entity
public class User extends Entity {
	
	private String userName;
	private String email;
	
	@OneToOne
	private Account account;
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private List<UserProfile> userProfiles;
	
	
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
	public List<UserProfile> getUserProfiles() {
		return userProfiles;
	}
	public void setUserProfiles(List<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
