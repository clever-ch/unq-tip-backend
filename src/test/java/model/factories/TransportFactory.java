package model.factories;

import root.model.Transport;

public class TransportFactory {

    public static Transport anyTransportService(){
        return new Transport();
    }
}
