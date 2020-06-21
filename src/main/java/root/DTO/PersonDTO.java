package root.DTO;

public class PersonDTO {

	public long Id;
	
	public String Name;
	public String SurName;
	public String Telephone;
	public String Address;
	public String Location;
	
	public boolean isValidPersonDTO() {
		return hasName() &
				hasSurname() &
				hasLocation() &
				hasAddress() & 
				hasTelephone();
	}
	private boolean hasAddress() {
		return this.Address != "" & this.Address != null;
	}
	
	private boolean hasLocation() {
		return this.Location != "" & this.Location != null;
	}
	
	private boolean hasTelephone() {
		return this.Telephone != "" & this.Telephone != null;
	}
	
	private boolean hasSurname() {
		return this.SurName != "" & this.SurName != null;
	}
	
	private boolean hasName() {
		return this.Name != "" & this.Name != null;
	}
}
