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
}
