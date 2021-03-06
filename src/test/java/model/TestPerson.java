package model;

import factories.PersonFactory;
import org.junit.Test;
import root.model.Person;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestPerson {

    @Test
    public void testPersonHasName() {

        final String PERSON_NAME = "Name";

        Person anyPerson = PersonFactory.createPersonWithName(PERSON_NAME);

        assertEquals(anyPerson.getName(), PERSON_NAME);
    }

    @Test
    public void testPersonHasSurName() {

        final String PERSON_SURNAME = "SurName";

        Person anyPerson = PersonFactory.createPersonWithSurname(PERSON_SURNAME);

        assertEquals(anyPerson.getSurName(), PERSON_SURNAME);
    }

    @Test
    public void testPersonHasTelephone() {

        final String PERSON_TELEPHONE = "Telephone";

        Person anyPerson = PersonFactory.createPersonWithTelephone(PERSON_TELEPHONE);

        assertEquals(anyPerson.getTelephone(), PERSON_TELEPHONE);
    }

    @Test
    public void testPersonHasAddress() {

        final String PERSON_ADDRESS = "address";

        Person anyPerson = PersonFactory.createPersonWithAddress(PERSON_ADDRESS);

        assertEquals(anyPerson.getAddress(), PERSON_ADDRESS);
    }

    @Test
    public void testPersonHasLocation() {

        final String PERSON_LOCATION = "Location";

        Person anyPerson = PersonFactory.createPersonWithLocation(PERSON_LOCATION);

        assertEquals(anyPerson.getLocation(), PERSON_LOCATION);
    }
    
    @Test
    public void testIsValidPerson() {
    	
    	Person anyPerson = PersonFactory.createPersonComplete("Carlos", "Perez", "12345", "Mitre", "Berazategui");
    	
    	assertTrue(anyPerson.isValidPerson());
    }

}