package model.factories;

import root.constants.AnimalType;
import root.model.Cat;

public class CatFactory {

    public static Cat anyCat() {return new Cat();}

    public static Cat createCompleteCat(AnimalType animalType, String breed, String size,String age, String description){
        Cat newCat = new Cat();
        newCat.setAnimalType(animalType);
        newCat.setBreed(breed);
        newCat.setSize(size);
        newCat.setAge(age);
        newCat.setDescription(description);

        return newCat;
    }

    public static Cat createCatWithAnimalType(AnimalType animalType){
        Cat newCat = new Cat();
        newCat.setAnimalType(animalType);

        return newCat;
    }

    public static Cat createCatWithBreed(String breed){
        Cat newCat = new Cat();
        newCat.setBreed(breed);

        return newCat;
    }

    public static Cat createCatWithSize(String size){
        Cat newCat = new Cat();
        newCat.setSize(size);

        return newCat;
    }

    public static Cat createCatWithAge(String age){
        Cat newCat = new Cat();
        newCat.setAge(age);

        return newCat;
    }

    public static Cat createCatWithDescription(String description){
        Cat newCat = new Cat();
        newCat.setDescription(description);

        return newCat;
    }
}
