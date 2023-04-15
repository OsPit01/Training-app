package command;

import container.UserContainer;
import container.UserSession;
import exception.LoginCommandException;
import exception.UserNotFoundException;

public class LoginCommand {
    public void execute(String userName, String password) throws LoginCommandException {

        try {
            if (UserContainer.isUserNameAndPasswordExists(userName, password)) {
                System.out.println("\n" + "Successful entry");
                UserSession.currentUser = UserContainer.findUserByUsernameAndPassword(userName, password);
            }

        } catch (UserNotFoundException e) {
            System.out.println("user with login = " + " " + userName + " " + "and password = " + " " + password + " " + "not found in the system");
            throw new LoginCommandException("login error", e);
        }
    }
}
