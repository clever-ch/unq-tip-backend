package modelDTO;

import root.DTO.AnimalDTO;
import root.constants.AnimalType;

public class AnimalDTOFactory {

    public static AnimalDTO createCompleteAnimal(AnimalType animalType, String breed, String size,String age, String description){
    	AnimalDTO newAnimal = new AnimalDTO();
        newAnimal.AnimalType = animalType;
        newAnimal.Breed = breed;
        newAnimal.AnimalSize = size;
        newAnimal.AnimalAge = age;
        newAnimal.AnimalDescription = description;

        return newAnimal;
    }
}
