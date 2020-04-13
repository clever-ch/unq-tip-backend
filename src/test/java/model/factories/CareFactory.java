package model.factories;

import root.constants.ServiceStatus;
import root.constants.UnidOfTime;
import root.model.Animal;
import root.model.Care;
import root.model.Transit;
import root.model.User;

public class CareFactory {

    public static Care anyCareService(){
        return new Care();
    }

    public static Transit createCompleteService(User aUser, ServiceStatus aServiceStatus, Animal aAnimal, String aDescription,
                                                UnidOfTime aUnidOfTime, int aTransitTime){
        Transit aTransitService = new Transit();
        aTransitService.setUser(aUser);
        aTransitService.setServiceStatus(aServiceStatus);
        aTransitService.setAnimal(aAnimal);
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

    public static Transit createTransitServiceWithAnimal(Animal aAnimal){
        Transit aTransitService = new Transit();
        aTransitService.setAnimal(aAnimal);

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
