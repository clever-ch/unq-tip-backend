package factories;

import root.model.Publication;
import root.model.PublicationHistory;
import root.model.User;

public class PublicationHistoryFactory {

    public static PublicationHistory anyPublicationHistory() {
        return new PublicationHistory();
    }

    public static PublicationHistory createPublicationHistoryWithUser(User aUser){
        PublicationHistory aPublicationHistory = new PublicationHistory();
        aPublicationHistory.setUser(aUser);
        return aPublicationHistory;
    }

    public static PublicationHistory createPublicationHistoryWithPublication(Publication aPublication){
        PublicationHistory aPublicationHistory = new PublicationHistory();
        aPublicationHistory.setPublication(aPublication);
        return aPublicationHistory;
    }

}
