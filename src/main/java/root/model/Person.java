package root.model;

import root.utilities.Entity;

@javax.persistence.Entity
public class Person extends Entity {
	
	private String address;
	private String location;
	private String name;
	private String surName;
	private String telephone;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isValidPerson() {
		return hasName() &
				hasSurname() &
				hasLocation() &
				hasAddress() & 
				hasTelephone();
	}
	private boolean hasAddress() {
		return this.address != "" & this.address != null;
	}
	private boolean hasLocation() {
		return this.location != "" & this.location != null;
	}
	private boolean hasTelephone() {
		return this.telephone != "" & this.telephone != null;
	}
	private boolean hasSurname() {
		return this.surName != "" & this.surName != null;
	}
	
	private boolean hasName() {
		return this.name != "" & this.name != null;
	}
	
	
}
