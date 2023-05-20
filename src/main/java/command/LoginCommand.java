package command;

import Service.UserService;
import repository.UserRepository;
import repository.UserSession;
import exception.LoginCommandException;
import exception.UserNotFoundException;

public class LoginCommand {
    public void execute(String userName, String password) throws LoginCommandException {

        try {
            UserService userService = new UserService();
            if (userService.isUserNameAndPasswordExists(userName, password)) {
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
