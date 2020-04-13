package model.factories;

import root.model.Account;
import root.model.User;

public class UserFactory {

    public static User anyUser() {
        return new User();
    }

    public static User createACompleteUser(String userName, String email, Account account){
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setEmail(email);
        newUser.setAccount(account);

        return newUser;
    }
}
