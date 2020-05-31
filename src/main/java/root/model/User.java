package root.model;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import root.controller.exceptions.EmailInvalidException;
import root.utilities.Entity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@javax.persistence.Entity
public class User extends Entity {
	
	private String email;
	private String password;
	private String userGuid;
	private String userName;
	
	@OneToOne(cascade=CascadeType.ALL)
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

	public boolean isValidUser() {
		return !isEmptyUsername()
                & !isEmptyEmail()
                & !isEmptyPassword()
                & hasAPersonComplete();
	}

	private boolean hasAPersonComplete() {
		return this.person.isValidPerson();
	}

	private boolean isEmptyEmail() {
		return this.email == null | this.email == "" ;
	}

	private boolean isEmptyPassword() {
		return this.password == null | this.password == "";
	}

	private boolean isEmptyUsername() {
		return this.userName == null | this.userName == "";
	}
}
