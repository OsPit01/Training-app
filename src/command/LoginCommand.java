package command;

import container.UserContainer;
import exception.LoginCommandException;
import exception.UserNotFoundException;

public class LoginCommand {
    public void execute(String userName, String password) {

        try {
            if (UserContainer.isUserNameAndPasswordExists(userName, password)) {
                System.out.println("\n" + "Successful entry");
            }
        } catch (UserNotFoundException e) {
            System.out.println("user with login = " + " " + userName + " " + "and password = " + " " + password + " " + "not found in the system");
            try {
                throw new LoginCommandException("login error", e);
            } catch (LoginCommandException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}