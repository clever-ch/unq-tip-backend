package factories;

import root.constants.ServiceStatus;
import root.constants.UnidOfTime;
import root.model.Transit;
import root.model.User;

public class TransitFactory {

    public static Transit anyTransitService(){
        return new Transit();
    }

    public static Transit createCompleteTransitService(User aUser, ServiceStatus aServiceStatus, String aDescription,
                                                UnidOfTime aUnidOfTime, int aTransitTime){
        Transit aTransitService = new Transit();
        aTransitService.setUser(aUser);
        aTransitService.setServiceStatus(aServiceStatus);
        aTransitService.setDescription(aDescription);
        aTransitService.setUnidOfTime(aUnidOfTime);
        aTransitService.setTransitTime(aTransitTime);

        return aTransitService;
    }

    public static Transit createTransitServiceWithUser(User aUser){
        Transit aTransitService = new Transit();
        aTransitService.setUser(aUser);

        return aTransitService;
    }

    public static Transit createTransitServiceWithServiceStatus(ServiceStatus aServiceStatus){
        Transit aTransitService = new Transit();
        aTransitService.setServiceStatus(aServiceStatus);

        return aTransitService;
    }

    public static Transit createTransitServiceWithDescription(String aDescription){
        Transit aTransitService = new Transit();
        aTransitService.setDescription(aDescription);

        return aTransitService;
    }

    public static Transit createTransitServiceWithUnidOfTime(UnidOfTime aUnidOfTime){
        Transit aTransitService = new Transit();
        aTransitService.setUnidOfTime(aUnidOfTime);

        return aTransitService;
    }

    public static Transit createTransitServiceWithTransitTime(int aTransitTime){
        Transit aTransitService = new Transit();
        aTransitService.setTransitTime(aTransitTime);

        return aTransitService;
    }

}
