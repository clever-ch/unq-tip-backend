package model.factories;

import root.model.Account;

public class AccountFactory {

    public static Account anyAccount() { return new Account(); }

    public static Account createAccountComplete(String aName, String aSurname, String aTelephone, String aAddress, String aLocation){
        Account aAccount = new Account();
        aAccount.setName(aName);
        aAccount.setSurName(aSurname);
        aAccount.setTelephone(aTelephone);
        aAccount.setAddress(aAddress);
        aAccount.setLocation(aLocation);

        return aAccount;
    }

    public static Account createAccountWithName(String aName){
        Account aAccount = new Account();
        aAccount.setName(aName);
        return aAccount;
    }

    public static Account createAccountWithSurname(String aSurname){
        Account aAccount = new Account();
        aAccount.setSurName(aSurname);
        return aAccount;
    }

    public static Account createAccountWithTelephone(String aTelephone){
        Account aAccount = new Account();
        aAccount.setTelephone(aTelephone);
        return aAccount;
    }

    public static Account createAccountWithAddress(String aAddress){
        Account aAccount = new Account();
        aAccount.setAddress(aAddress);
        return aAccount;
    }

    public static Account createAccountWithLocation(String aLocation){
        Account aAccount = new Account();
        aAccount.setLocation(aLocation);
        return aAccount;
    }
}
