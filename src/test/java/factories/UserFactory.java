package factories;

import root.model.Person;
import root.model.User;

public class UserFactory {

    public static User anyUser() {
        return new User();
    }

    public static User createACompleteUser(String userName, String email, String pass, Person person){

        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setPassword(pass);
        newUser.setEmail(email);
        newUser.setPerson(person);
        
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
    
    public static User createAUserWithUserNamePasswordAndUserGuid(String aUserName, String aPassword, String aUserGuid){
        User newUser = new User();
        newUser.setUserName(aUserName);
        newUser.setUserGuid(aUserGuid);
        return newUser;
    }
}
