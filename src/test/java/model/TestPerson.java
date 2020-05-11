package model;

import model.factories.PersonFactory;
import org.junit.Test;
import root.model.Person;


import static org.junit.Assert.assertEquals;

public class TestPerson {

    @Test
    public void testAccountHasName() {

        final String ACCOUNT_NAME = "Name";

        Person anyAccount = PersonFactory.createAccountWithName(ACCOUNT_NAME);

        assertEquals(anyAccount.getName(), ACCOUNT_NAME);
    }

    @Test
    public void testAccountHasSurName() {

        final String ACCOUNT_SURNAME = "SurName";

        Person anyAccount = PersonFactory.createAccountWithSurname(ACCOUNT_SURNAME);

        assertEquals(anyAccount.getSurName(), ACCOUNT_SURNAME);
    }

    @Test
    public void testAccountHasTelephone() {

        final String ACCOUNT_TELEPHONE = "Telephone";

        Person anyAccount = PersonFactory.createAccountWithTelephone(ACCOUNT_TELEPHONE);

        assertEquals(anyAccount.getTelephone(), ACCOUNT_TELEPHONE);
    }

    @Test
    public void testAccountHasAddress() {

        final String ACCOUNT_ADDRESS = "address";

        Person anyAccount = PersonFactory.createAccountWithAddress(ACCOUNT_ADDRESS);

        assertEquals(anyAccount.getAddress(), ACCOUNT_ADDRESS);
    }

    @Test
    public void testAccountHasLocation() {

        final String ACCOUNT_LOCATION = "Location";

        Person anyAccount = PersonFactory.createAccountWithLocation(ACCOUNT_LOCATION);

        assertEquals(anyAccount.getLocation(), ACCOUNT_LOCATION);
    }

}