package root.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import root.utilities.Entity;


@javax.persistence.Entity
public class User extends Entity {
	
	private String email;
	private String password;
	private String userGuid;
	private String userName;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Publication> publicaciones;
	
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
                & !isEmptyPassword();
                //& hasAPersonComplete();
	}

	//Aclaración: Se saca validación a modo parche por el problema con la persistencia donde se duplican los registros
	/*private boolean hasAPersonComplete() {
		return this.person.isValidPerson();
	}*/

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
