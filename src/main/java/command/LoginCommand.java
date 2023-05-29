package command;

import exception.LoginCommandException;
import exception.UserNotFoundException;
import repository.UserRepository;
import service.UserService;

public class LoginCommand {
    private final UserService userService = new UserService();

    public void execute(String userName, String password) throws LoginCommandException {
        try {
            userService.login(userName, password);
            UserRepository.findUserByUsernameAndPassword(userName, password);
            System.out.println("Command successful");

        } catch (UserNotFoundException e) {
            System.out.println("user with login = " + " " +
                    userName + " " + "and password = " + " " +
                    password + " " + "not found in the system");
            throw new LoginCommandException("login error", e);
        }
    }
}
