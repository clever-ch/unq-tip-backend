package factories;

import root.constants.ServiceStatus;
import root.constants.UnidOfTime;
import root.model.Animal;
import root.model.Transport;
import root.model.User;

public class TransportFactory {

    public static Transport anyTransportService(){
        return new Transport();
    }

    public static Transport createCompleteTransportService(User aUser, ServiceStatus aServiceStatus, Animal aAnimal, String aDescription,
                                                UnidOfTime aUnidOfTime, int scheduleAvailable){
        Transport aTransportService = new Transport();
        aTransportService.setUser(aUser);
        aTransportService.setServiceStatus(aServiceStatus);
        aTransportService.setAnimal(aAnimal);
        aTransportService.setDescription(aDescription);
        aTransportService.setUnidOfTime(aUnidOfTime);
        aTransportService.setScheduleAvailable(scheduleAvailable);

        return aTransportService;
    }

    public static Transport createTransportServiceWithUser(User aUser){
        Transport aTransportService = new Transport();
        aTransportService.setUser(aUser);

        return aTransportService;
    }

    public static Transport createTransportServiceWithServiceStatus(ServiceStatus aServiceStatus){
        Transport aTransportService = new Transport();
        aTransportService.setServiceStatus(aServiceStatus);

        return aTransportService;
    }

    public static Transport createTransportServiceWithAnimal(Animal aAnimal){
        Transport aTransportService = new Transport();
        aTransportService.setAnimal(aAnimal);

        return aTransportService;
    }

    public static Transport createTransportServiceWithDescription(String aDescription){
        Transport aTransportService = new Transport();
        aTransportService.setDescription(aDescription);

        return aTransportService;
    }

    public static Transport createTransportServiceWithUnidOfTime(UnidOfTime aUnidOfTime){
        Transport aTransportService = new Transport();
        aTransportService.setUnidOfTime(aUnidOfTime);

        return aTransportService;
    }

    public static Transport createTransportServiceWithTransitTime(int scheduleAvailable){
        Transport aTransportService = new Transport();
        aTransportService.setScheduleAvailable(scheduleAvailable);

        return aTransportService;
    }

}
