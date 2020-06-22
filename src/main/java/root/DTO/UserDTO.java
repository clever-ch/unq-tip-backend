package root.DTO;

public class UserDTO {
	
	public long Id;
	public String UserName;
	public String Email;
	public String Password;
	public String UserGuid;
	
	public PersonDTO PersonDTO;
	
	public boolean isValidUserDTO() {
		return !isEmptyUsername()
                & !isEmptyEmail()
                & !isEmptyPassword()
                & hasAPersonComplete();
	}
	
	private boolean hasAPersonComplete() {
		return this.PersonDTO.isValidPersonDTO();
	}

	private boolean isEmptyEmail() {
		return this.Email == null | this.Email == "" ;
	}

	private boolean isEmptyPassword() {
		return this.Password == null | this.Password == "";
	}

	private boolean isEmptyUsername() {
		return this.UserName == null | this.UserName == "";
	}
}
