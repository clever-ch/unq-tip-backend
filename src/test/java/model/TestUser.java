package model;

import model.factories.AccountFactory;
import model.factories.UserFactory;
import org.junit.Test;
import root.model.Account;
import root.model.User;

import static org.junit.Assert.assertEquals;

public class TestUser {

    @Test
    public void testUserHasUserName() {
        final String USER_USERNAME = "uSName";

        User anyUser = UserFactory.createAUserWithUserName(USER_USERNAME);

        assertEquals(anyUser.getUserName(), USER_USERNAME);
    }

    @Test
    public void testUserHasEmail() {
        final String USER_EMAIL = "aEmail@mail.com";

        User anyUser = UserFactory.createAUserWithEmail(USER_EMAIL);

        assertEquals(anyUser.getEmail(), USER_EMAIL);
    }

    @Test
    public void testUserHasAccount() {

        Account aAccount = AccountFactory.anyAccount();

        User anyUser = UserFactory.createAUserWithAccount(aAccount);

        assertEquals(anyUser.getAccount(), aAccount);
    }
}
