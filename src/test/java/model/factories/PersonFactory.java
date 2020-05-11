package model.factories;

import root.model.Person;

public class PersonFactory {

    public static Person anyAccount() { return new Person(); }

    public static Person createAccountComplete(String aName, String aSurname, String aTelephone, String aAddress, String aLocation){
        Person aAccount = new Person();
        aAccount.setName(aName);
        aAccount.setSurName(aSurname);
        aAccount.setTelephone(aTelephone);
        aAccount.setAddress(aAddress);
        aAccount.setLocation(aLocation);

        return aAccount;
    }

    public static Person createAccountWithName(String aName){
        Person aAccount = new Person();
        aAccount.setName(aName);
        return aAccount;
    }

    public static Person createAccountWithSurname(String aSurname){
        Person aAccount = new Person();
        aAccount.setSurName(aSurname);
        return aAccount;
    }

    public static Person createAccountWithTelephone(String aTelephone){
        Person aAccount = new Person();
        aAccount.setTelephone(aTelephone);
        return aAccount;
    }

    public static Person createAccountWithAddress(String aAddress){
        Person aAccount = new Person();
        aAccount.setAddress(aAddress);
        return aAccount;
    }

    public static Person createAccountWithLocation(String aLocation){
        Person aAccount = new Person();
        aAccount.setLocation(aLocation);
        return aAccount;
    }
}
