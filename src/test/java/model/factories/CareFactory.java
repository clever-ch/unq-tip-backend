package model.factories;

import root.model.Care;

public class CareFactory {

    public static Care anyCareService(){
        return new Care();
    }
}
