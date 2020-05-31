package model;

import factories.PublicationFactory;
import factories.PublicationHistoryFactory;
import factories.UserFactory;
import org.junit.Test;
import root.model.Publication;
import root.model.PublicationHistory;
import root.model.User;

import static org.junit.Assert.assertEquals;

public class TestPublicationHistory {

    @Test
    public void testHasUserValid(){

        User aUser = UserFactory.createAUserWithUserName("ABC123");

        PublicationHistory aPublicationHistory = PublicationHistoryFactory.createPublicationHistoryWithUser(aUser);

        assertEquals(aUser.getUserName(), aPublicationHistory.getUser().getUserName());
        assertEquals(aPublicationHistory.getUser(), aUser);
    }

    @Test
    public void testHasAPublication(){

        Publication aPublication = PublicationFactory.anyPublication();

        PublicationHistory aPublicationHistory = PublicationHistoryFactory.createPublicationHistoryWithPublication(aPublication);

        assertEquals(aPublication, aPublicationHistory.getPublication());
    }
}
