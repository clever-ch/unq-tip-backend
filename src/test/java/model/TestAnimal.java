package model;

import factories.AnimalFactory;
import org.junit.Test;
import root.constants.AnimalType;
import root.model.Animal;

import static org.junit.Assert.assertEquals;

public class TestAnimal {

        @Test
        public void testAnimalHasType() {

            final AnimalType Animal_TYPE = AnimalType.CAT;

            Animal anyAnimal = AnimalFactory.createAnimalWithAnimalType(Animal_TYPE);

            assertEquals(anyAnimal.getAnimalType(), Animal_TYPE);
        }

        @Test
        public void testAnimalHasBreed() {

            final String Animal_BREED = "aBreed";

            Animal anyAnimal = AnimalFactory.createAnimalWithBreed(Animal_BREED);

            assertEquals(anyAnimal.getBreed(), Animal_BREED);
        }

        @Test
        public void testAnimalHasSize() {

            final String Animal_SIZE = "Size";

            Animal anyAnimal = AnimalFactory.createAnimalWithSize(Animal_SIZE);

            assertEquals(anyAnimal.getSize(), Animal_SIZE);
        }

        @Test
        public void testAnimalHasAge() {

            final String Animal_AGE = "AGE";

            Animal anyAnimal = AnimalFactory.createAnimalWithAge(Animal_AGE);

            assertEquals(anyAnimal.getAge(), Animal_AGE);
        }

        @Test
        public void testAnimalHasDescription() {

            final String Animal_DESCRIPTION = "Esta es un descripcion";

            Animal anyAnimal = AnimalFactory.createAnimalWithDescription(Animal_DESCRIPTION);

            assertEquals(anyAnimal.getDescription(), Animal_DESCRIPTION);
        }
}

