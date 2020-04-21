package model;

import model.factories.AccountFactory;
import org.junit.Test;
import root.model.Account;


import static org.junit.Assert.assertEquals;

public class TestAccount {

    @Test
    public void testAccountHasName() {

        final String ACCOUNT_NAME = "Name";

        Account anyAccount = AccountFactory.createAccountWithName(ACCOUNT_NAME);

        assertEquals(anyAccount.getName(), ACCOUNT_NAME);
    }

    @Test
    public void testAccountHasSurName() {

        final String ACCOUNT_SURNAME = "SurName";

        Account anyAccount = AccountFactory.createAccountWithSurname(ACCOUNT_SURNAME);

        assertEquals(anyAccount.getSurName(), ACCOUNT_SURNAME);
    }

    @Test
    public void testAccountHasTelephone() {

        final String ACCOUNT_TELEPHONE = "Telephone";

        Account anyAccount = AccountFactory.createAccountWithTelephone(ACCOUNT_TELEPHONE);

        assertEquals(anyAccount.getTelephone(), ACCOUNT_TELEPHONE);
    }

    @Test
    public void testAccountHasAddress() {

        final String ACCOUNT_ADDRESS = "address";

        Account anyAccount = AccountFactory.createAccountWithAddress(ACCOUNT_ADDRESS);

        assertEquals(anyAccount.getAddress(), ACCOUNT_ADDRESS);
    }

    @Test
    public void testAccountHasLocation() {

        final String ACCOUNT_LOCATION = "Location";

        Account anyAccount = AccountFactory.createAccountWithLocation(ACCOUNT_LOCATION);

        assertEquals(anyAccount.getLocation(), ACCOUNT_LOCATION);
    }

}