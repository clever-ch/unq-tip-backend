package model.factories;

import root.model.Person;

public class PersonFactory {

    public static Person anyPerson() { return new Person(); }

    public static Person createPersonComplete(String aName, String aSurname, String aTelephone, String aAddress, String aLocation){

        Person aAccount = new Person();
        aAccount.setName(aName);
        aAccount.setSurName(aSurname);
        aAccount.setTelephone(aTelephone);
        aAccount.setAddress(aAddress);
        aAccount.setLocation(aLocation);

        return aAccount;
    }

    public static Person createPersonWithName(String aName){
        Person aAccount = new Person();
        aAccount.setName(aName);
        return aAccount;
    }

    public static Person createPersonWithSurname(String aSurname){

        Person aAccount = new Person();
        aAccount.setSurName(aSurname);
        return aAccount;
    }


    public static Person createPersonWithTelephone(String aTelephone){

        Person aAccount = new Person();
        aAccount.setTelephone(aTelephone);
        return aAccount;
    }

    public static Person createPersonWithAddress(String aAddress){

        Person aAccount = new Person();
        aAccount.setAddress(aAddress);
        return aAccount;
    }

    public static Person createPersonWithLocation(String aLocation){

        Person aAccount = new Person();
        aAccount.setLocation(aLocation);
        return aAccount;
    }
}
