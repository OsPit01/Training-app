package command;

import container.UserContainer;
import container.UserSession;
import exception.LoginCommandException;
import exception.UserNotFoundException;

public class LoginCommand {
    public void execute(String userName, String password, String status) throws LoginCommandException {

        try {
            if (UserContainer.isUserNameAndPasswordExists(userName, password, status)) {
                UserSession.currentUser = UserContainer.findUserByUsernameAndPassword(userName, password, status);
            }
            System.out.println("\n" + "Command successful");

        } catch (UserNotFoundException e) {
            System.out.println("user with login = " + " " +
                    userName + " " + "and password = " + " " +
                    password + " " + "not found in the system");
            throw new LoginCommandException("login error", e);
        }
    }
}
