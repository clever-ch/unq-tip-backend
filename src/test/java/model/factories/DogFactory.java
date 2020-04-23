package model.factories;

import root.constants.AnimalType;
import root.model.Dog;

public class DogFactory {
    public static Dog anyDog() {return new Dog();}

    public static Dog createCompleteDog(AnimalType animalType, String breed, String size, String age, String description){
        Dog newDog = new Dog();
        newDog.setAnimalType(animalType);
        newDog.setBreed(breed);
        newDog.setSize(size);
        newDog.setAge(age);
        newDog.setDescription(description);

        return newDog;
    }
}

