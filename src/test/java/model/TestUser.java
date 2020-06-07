package model;

import factories.PersonFactory;
import factories.UserFactory;
import org.junit.Test;
import root.model.Person;
import root.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

        Person aAccount = PersonFactory.anyPerson();

        User anyUser = UserFactory.createAUserWithAccount(aAccount);

        assertEquals(anyUser.getPerson(), aAccount);
    }
    
    @Test
    public void testIsValidUser() {
    	Person anyPerson = PersonFactory.createPersonComplete("Carlos", "Perez", "12345", "Mitre", "Berazategui");
    	
    	User anyUser = UserFactory.createACompleteUser("Pepe", "pepe@gmail.com", "123456", anyPerson);
    	
    	assertTrue(anyUser.isValidUser());
    }
}
