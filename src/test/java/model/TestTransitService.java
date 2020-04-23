package model;

import model.factories.DogFactory;
import model.factories.TransitFactory;
import model.factories.UserFactory;
import org.junit.Test;
import root.constants.ServiceStatus;
import root.constants.UnidOfTime;
import root.model.Dog;
import root.model.Transit;
import root.model.User;

import static org.junit.Assert.assertEquals;

public class TestTransitService {

    @Test
    public void testTransitServiceHasUser(){

        final User TRANSIT_USER = UserFactory.anyUser();

        Transit aTransit = TransitFactory.createTransitServiceWithUser(TRANSIT_USER);

        assertEquals(aTransit.getUser(), TRANSIT_USER);
    }


    @Test
    public void testTransitServiceHasServiceStatus(){

        final ServiceStatus TRANSIT_SERVICESTATUS = ServiceStatus.Active;

        Transit aTransit = TransitFactory.createTransitServiceWithServiceStatus(TRANSIT_SERVICESTATUS);

        assertEquals(aTransit.getServiceStatus(), TRANSIT_SERVICESTATUS);

    }

    @Test
    public void testTransitServiceHasAnimal(){

        final Dog TRANSIT_ANIMAL = DogFactory.anyDog();

        Transit aTransit = TransitFactory.createTransitServiceWithAnimal(TRANSIT_ANIMAL);

        assertEquals(aTransit.getAnimal(), TRANSIT_ANIMAL);

    }

    @Test
    public void testTransitServiceHasDescription(){

        final String TRANSIT_DESCRIPTION = "Esto es una descripcion";

        Transit aTransit = TransitFactory.createTransitServiceWithDescription(TRANSIT_DESCRIPTION);

        assertEquals(aTransit.getDescription(), TRANSIT_DESCRIPTION);
    }

    @Test
    public void testTransitServiceHasUnidOfTime(){

        final UnidOfTime TRANSIT_UNIDOFTIME = UnidOfTime.Months;

        Transit aTransit = TransitFactory.createTransitServiceWithUnidOfTime(TRANSIT_UNIDOFTIME);

        assertEquals(aTransit.getUnidOfTime(), TRANSIT_UNIDOFTIME);

    }

    @Test
    public void testTransitServiceHasTime(){

        final int TRANSIT_TIME = 5;

        Transit aTransit = TransitFactory.createTransitServiceWithTransitTime(TRANSIT_TIME);

        assertEquals(aTransit.getTransitTime(), TRANSIT_TIME);

    }
}