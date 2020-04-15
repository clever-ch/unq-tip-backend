package model;

import model.factories.DogFactory;
import org.junit.Test;
import root.constants.AnimalType;
import root.model.Dog;

import static org.junit.Assert.assertEquals;

public class TestDog {

    @Test
    public void testDogHasType() {

        final AnimalType DOG_TYPE = AnimalType.Mammal;

        Dog anyDog = DogFactory.createDogWithAnimalType(DOG_TYPE);

        assertEquals(anyDog.getAnimalType(), DOG_TYPE);
    }

    @Test
    public void testDogHasBreed() {

        final String DOG_BREED = "aBreed";

        Dog anyDog = DogFactory.createDogWithBreed(DOG_BREED);

        assertEquals(anyDog.getBreed(), DOG_BREED);
    }

    @Test
    public void testDogHasSize() {

        final String DOG_SIZE = "Size";

        Dog anyDog = DogFactory.createDogWithSize(DOG_SIZE);

        assertEquals(anyDog.getSize(), DOG_SIZE);
    }

    @Test
    public void testDogHasAge() {

        final String DOG_AGE = "AGE";

        Dog anyDog = DogFactory.createDogWithAge(DOG_AGE);

        assertEquals(anyDog.getAge(), DOG_AGE);
    }

    @Test
    public void testDogHasDescription() {

        final String DOG_DESCRIPTION = "Esta es un descripcion";

        Dog anyDog = DogFactory.createDogWithDescription(DOG_DESCRIPTION);

        assertEquals(anyDog.getDescription(), DOG_DESCRIPTION);
    }
}
