package command;

import exception.UserNotFoundException;
import model.User;
import model.UserRole;
import model.UserStatus;
import repository.UserRepository;

public class BanUsersCommand {
    public void execute(String userName) throws UserNotFoundException {
        User user = UserRepository.findUserByUsername(userName);

        if (UserRole.ADMIN == user.getRole()) {
            System.out.println("this is Admin");
            return;
        }
        user.setStatus(UserStatus.BAN);
        System.out.println("User is in ban");
    }
}
