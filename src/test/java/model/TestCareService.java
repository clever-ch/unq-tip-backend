package model;

import factories.AnimalFactory;
import factories.CareFactory;
import factories.TransportFactory;
import factories.UserFactory;
import org.junit.Test;
import root.constants.ServiceStatus;
import root.constants.UnidOfTime;
import root.model.Animal;
import root.model.Care;
import root.model.Transport;
import root.model.User;
import static org.junit.Assert.assertEquals;


public class TestCareService {

    @Test
    public void testCareServiceHasUser(){

        final User CARE_USER = UserFactory.anyUser();

        Care aCare = CareFactory.createCareServiceWithUser(CARE_USER);

        assertEquals(aCare.getUser(), CARE_USER);
    }


    @Test
    public void testCareServiceHasServiceStatus(){

        final ServiceStatus CARE_SERVICESTATUS = ServiceStatus.Active;

        Care aCare = CareFactory.createCareServiceWithServiceStatus(CARE_SERVICESTATUS);

        assertEquals(aCare.getServiceStatus(), CARE_SERVICESTATUS);
    }

    @Test
    public void testTransportServiceHasAnimal(){

        final Animal CARE_ANIMAL = AnimalFactory.anyAnimal();

        Transport aTransport = TransportFactory.createTransportServiceWithAnimal(CARE_ANIMAL);

        assertEquals(aTransport.getAnimal(), CARE_ANIMAL);
    }
    

    @Test
    public void testCareServiceHasDescription(){

        final String CARE_DESCRIPTION = "Esto es una descripcion";

        Care aCare = CareFactory.createCareServiceWithDescription(CARE_DESCRIPTION);

        assertEquals(aCare.getDescription(), CARE_DESCRIPTION);
    }

    @Test
    public void testCareServiceHasUnidOfTime(){

        final UnidOfTime CARE_UNIDOFTIME = UnidOfTime.Months;

        Care aCare = CareFactory.createCareServiceWithUnidOfTime(CARE_UNIDOFTIME);

        assertEquals(aCare.getUnidOfTime(), CARE_UNIDOFTIME);
    }

    @Test
    public void testCareServiceHasCareTime(){

        final int CARE_TIME = 5;

        Care aCare = CareFactory.createCareServiceWithCareTime(CARE_TIME);

        assertEquals(aCare.getCareTime(), CARE_TIME);
    }

}
