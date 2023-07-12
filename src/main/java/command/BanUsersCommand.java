package command;

import exception.UserNotFoundException;
import model.User;
import model.UserRole;
import model.UserStatus;
import service.UserService;

public class BanUsersCommand {
    private final UserService userService = new UserService();

    public void execute(long id) throws UserNotFoundException {
        User user = userService.getUserById(id);

        if (UserRole.ADMIN == user.getRole()) {
            System.out.println("this is Admin");
            return;
        }
        user.setStatus(UserStatus.BAN);
        System.out.println("User is in ban");
    }
}
