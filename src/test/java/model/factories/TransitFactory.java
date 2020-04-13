package model.factories;

import root.model.Transit;

public class TransitFactory {

    public static Transit anyTransitService(){
        return new Transit();
    }
}
