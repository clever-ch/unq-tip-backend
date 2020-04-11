package root.model;

import java.util.List;
import root.constants.UserProfile;
import root.utilities.Entity;

public class User extends Entity {
	private String userName;
	private String email;
	private List<UserProfile> userProfiles;
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
