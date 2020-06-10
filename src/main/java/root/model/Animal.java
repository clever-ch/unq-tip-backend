package root.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import root.constants.AnimalType;
import root.utilities.Entity;

@javax.persistence.Entity
public class Animal extends Entity {
	
	@Column(nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private AnimalType animalType;
	private String age;
	private String breed;
	
	private String description;
	private String size;
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AnimalType getAnimalType() {
		return animalType;
	}
	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}
}
