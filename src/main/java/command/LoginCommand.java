package command;

import exception.LoginCommandException;
import exception.UserNotFoundException;
import repository.UserRepository;
import repository.UserSession;
import service.UserService;

public class LoginCommand {
    private final UserService userService = new UserService();

    public void execute(String userName, String password) throws LoginCommandException {
        try {

            if (userService.login(userName, password)) {
                UserSession.currentUser = UserRepository.findUserByUsernameAndPassword(userName, password);
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
