package model;

import model.factories.CatFactory;
import org.junit.Test;
import root.constants.AnimalType;
import root.model.Cat;

import static org.junit.Assert.assertEquals;

public class TestCat {

    @Test
    public void testCatHasType() {

        final AnimalType CAT_TYPE = AnimalType.Mammal;

        Cat anyCat = CatFactory.createCatWithAnimalType(CAT_TYPE);

        assertEquals(anyCat.getAnimalType(), CAT_TYPE);
    }

    @Test
    public void testCatHasBreed() {

        final String CAT_BREED = "aBreed";

        Cat anyCat = CatFactory.createCatWithBreed(CAT_BREED);

        assertEquals(anyCat.getBreed(), CAT_BREED);
    }

    @Test
    public void testCatHasSize() {

        final String CAT_SIZE = "Size";

        Cat anyCat = CatFactory.createCatWithSize(CAT_SIZE);

        assertEquals(anyCat.getSize(), CAT_SIZE);
    }

    @Test
    public void testCatHasAge() {

        final String CAT_AGE = "AGE";

        Cat anyCat = CatFactory.createCatWithAge(CAT_AGE);

        assertEquals(anyCat.getAge(), CAT_AGE);
    }

    @Test
    public void testCatHasDescription() {

        final String CAT_DESCRIPTION = "Esta es un descripcion";

        Cat anyCat = CatFactory.createCatWithDescription(CAT_DESCRIPTION);

        assertEquals(anyCat.getDescription(), CAT_DESCRIPTION);
    }
}
