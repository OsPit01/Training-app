package command;

import exception.LoginCommandException;
import exception.LoginException;
import repository.service.UserService;

public class LoginCommand {
    private final UserService userService = new UserService();

    public void execute(String username, String password) throws LoginCommandException {
        try {
            userService.login(username, password);
            System.out.println("Command successful");
        } catch (LoginException e) {
            System.out.println("user with login = " + " " +
                    username + " " + "and password = " + " " +
                    password + " " + "not found in the system");
            throw new LoginCommandException("login error", e);
        }
    }
}
