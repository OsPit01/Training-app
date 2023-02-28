package command;

import container.UserContainer;
import exception.LoginCommandException;

public class LoginCommand {
    public void execute(String userName, String password) throws LoginCommandException {

        try {
            if (UserContainer.isUserNameAndPasswordExists(userName, password)) {
                System.out.println("\n" + "Successful entry");
            }
        } catch (Exception e) {
            System.out.println("user with login = " + " " + userName + " " + "and password = " + " " + password + " " + "not found in the system");
            throw new LoginCommandException("login error", e);
        }
    }
}