package model;

import model.factories.AccountFactory;
import model.factories.UserFactory;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TestAccount {
    @Test
    public void testAccountHasName() {
        final String ACCOUNT_USERNAME = "uSName";

        Account anyAccount = AccountFactory.createAccountWithName();


        assertEquals(anyUser.getUserName(), ACCOUNT_USERNAME);
}
