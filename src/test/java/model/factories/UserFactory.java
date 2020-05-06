package model.factories;

import root.model.Person;
import root.model.User;

public class UserFactory {

    public static User anyUser() {
        return new User();
    }

    public static User createACompleteUser(String userName, String email, Person account){
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setEmail(email);
        newUser.setPerson(account);

        return newUser;
    }

    public static User createAUserWithUserName(String aUserName){
        User newUser = new User();
        newUser.setUserName(aUserName);
        return newUser;
    }

    public static User createAUserWithEmail(String aEmail){
        User newUser = new User();
        newUser.setEmail(aEmail);
        return newUser;
    }

    public static User createAUserWithAccount(Person aAccount){
        User newUser = new User();
        newUser.setPerson(aAccount);
        return newUser;
    }
}
