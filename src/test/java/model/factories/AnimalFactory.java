package model.factories;

import root.constants.AnimalType;
import root.model.Animal;


public class AnimalFactory {

    public static Animal anyAnimal() {return new Animal();}

    public static Animal createCompleteAnimal(AnimalType animalType, String breed, String size,String age, String description){
        Animal newAnimal = new Animal();
        newAnimal.setAnimalType(animalType);
        newAnimal.setBreed(breed);
        newAnimal.setSize(size);
        newAnimal.setAge(age);
        newAnimal.setDescription(description);

        return newAnimal;
    }

    public static Animal createAnimalWithAnimalType(AnimalType animalType){
        Animal newAnimal = new Animal();
        newAnimal.setAnimalType(animalType);

        return newAnimal;
    }

    public static Animal createAnimalWithBreed(String breed){
        Animal newAnimal = new Animal();
        newAnimal.setBreed(breed);

        return newAnimal;
    }

    public static Animal createAnimalWithSize(String size){
        Animal newAnimal = new Animal();
        newAnimal.setSize(size);

        return newAnimal;
    }

    public static Animal createAnimalWithAge(String age){
        Animal newAnimal = new Animal();
        newAnimal.setAge(age);

        return newAnimal;
    }

    public static Animal createAnimalWithDescription(String description){
        Animal newAnimal = new Animal();
        newAnimal.setDescription(description);

        return newAnimal;
    }
}
