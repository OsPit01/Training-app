package command;

import model.User;
import service.UserService;

public class RegisterCommand {
    private final UserService userService = new UserService();

    public void execute(User user) {
        if (userService.isUserExists(user.getUsername())) {
            System.out.println("such a user exist already");
        }
    }
}
