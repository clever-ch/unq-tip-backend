package root.transformers;

import root.DTO.AnimalDTO;
import root.model.Animal;
import root.model.Publication;

public class AnimalTransformer {

	public static Animal ConvertAnimalDToToAnimal(AnimalDTO animalDTO) {
		
		Animal animal = new Animal();
		animal.setAnimalType(animalDTO.AnimalType);
		animal.setBreed(animalDTO.Breed);
		animal.setAge(animalDTO.AnimalAge);
		animal.setDescription(animalDTO.AnimalDescription);
		animal.setSize(animalDTO.AnimalSize);
		
		return animal;
	}
	
	public static AnimalDTO GetAnimalDTOByPublication(Publication publication)
	{
		AnimalDTO animalDTO = new AnimalDTO();
		animalDTO.Id = publication.getAnimal().getId();
		animalDTO.Breed = publication.getAnimal().getBreed();
		animalDTO.AnimalSize = publication.getAnimal().getSize();
		animalDTO.AnimalAge = publication.getAnimal().getAge();
		animalDTO.AnimalDescription = publication.getAnimal().getDescription();
		animalDTO.AnimalType = publication.getAnimal().getAnimalType();
		
		return animalDTO;
	}
}
