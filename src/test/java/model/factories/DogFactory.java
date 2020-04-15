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

    public static Dog createDogWithAnimalType(AnimalType animalType){
        Dog newDog = new Dog();
        newDog.setAnimalType(animalType);

        return newDog;
    }

    public static Dog createDogWithBreed(String breed){
        Dog newDog = new Dog();
        newDog.setBreed(breed);

        return newDog;
    }

    public static Dog createDogWithSize(String size){
        Dog newDog = new Dog();
        newDog.setSize(size);

        return newDog;
    }

    public static Dog createDogWithAge(String age){
        Dog newDog = new Dog();
        newDog.setAge(age);

        return newDog;
    }

    public static Dog createDogWithDescription(String description){
        Dog newDog = new Dog();
        newDog.setDescription(description);

        return newDog;
    }
}

