package model;

import factories.TransportFactory;
import factories.UserFactory;
import org.junit.Test;
import root.constants.ServiceStatus;
import root.constants.UnidOfTime;
import root.model.Transport;
import root.model.User;
import static org.junit.Assert.assertEquals;


public class TestTransportService {

    @Test
    public void testTransportServiceHasUser(){

        final User TRANSPORT_USER = UserFactory.anyUser();

        Transport aTransport = TransportFactory.createTransportServiceWithUser(TRANSPORT_USER);

        assertEquals(aTransport.getUser(), TRANSPORT_USER);
    }


    @Test
    public void testTransportServiceHasServiceStatus(){

        final ServiceStatus TRANSPORT_SERVICESTATUS = ServiceStatus.Activo;

        Transport aTransport = TransportFactory.createTransportServiceWithServiceStatus(TRANSPORT_SERVICESTATUS);

        assertEquals(aTransport.getServiceStatus(), TRANSPORT_SERVICESTATUS);
    }

    @Test
    public void testTransportServiceHasDescription(){

        final String TRANSPORT_DESCRIPTION = "Esto es una descripcion";

        Transport aTransport = TransportFactory.createTransportServiceWithDescription(TRANSPORT_DESCRIPTION);

        assertEquals(aTransport.getDescription(), TRANSPORT_DESCRIPTION);
    }

    @Test
    public void testTransportServiceHasUnidOfTime(){

        final UnidOfTime TRANSPORT_UNIDOFTIME = UnidOfTime.Meses;

        Transport aTransport = TransportFactory.createTransportServiceWithUnidOfTime(TRANSPORT_UNIDOFTIME);

        assertEquals(aTransport.getUnidOfTime(), TRANSPORT_UNIDOFTIME);
    }

    @Test
    public void testTransportServiceHasScheduleAvailable(){

        final int TRANSPORT_TIME = 5;

        Transport aTransport = TransportFactory.createTransportServiceWithTransitTime(TRANSPORT_TIME);

        assertEquals(aTransport.getScheduleAvailable(), TRANSPORT_TIME);
    }

}
