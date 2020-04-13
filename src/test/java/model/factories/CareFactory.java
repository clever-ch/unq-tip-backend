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

    public static Care createCompleteCareService(User aUser, ServiceStatus aServiceStatus, Animal aAnimal, String aDescription,
                                                UnidOfTime aUnidOfTime, int careTime){
        Care aCareService = new Care();
        aCareService.setUser(aUser);
        aCareService.setServiceStatus(aServiceStatus);
        aCareService.setAnimal(aAnimal);
        aCareService.setDescription(aDescription);
        aCareService.setUnidOfTime(aUnidOfTime);
        aCareService.setCareTime(careTime);

        return aCareService;
    }

    public static Care createCareServiceWithUser(User aUser){
        Care aCareService = new Care();
        aCareService.setUser(aUser);

        return aCareService;
    }

    public static Care createCareServiceWithServiceStatus(ServiceStatus aServiceStatus){
        Care aCareService = new Care();
        aCareService.setServiceStatus(aServiceStatus);

        return aCareService;
    }

    public static Care createCareServiceWithAnimal(Animal aAnimal){
        Care aCareService = new Care();
        aCareService.setAnimal(aAnimal);

        return aCareService;
    }

    public static Care createCareServiceWithDescription(String aDescription){
        Care aCareService = new Care();
        aCareService.setDescription(aDescription);

        return aCareService;
    }

    public static Care createCareServiceWithUnidOfTime(UnidOfTime aUnidOfTime){
        Care aCareService = new Care();
        aCareService.setUnidOfTime(aUnidOfTime);

        return aCareService;
    }

    public static Care createCareServiceWithCareTime(int aCareTime){
        Care aCareService = new Care();
        aCareService.setCareTime(aCareTime);

        return aCareService;
    }

}
