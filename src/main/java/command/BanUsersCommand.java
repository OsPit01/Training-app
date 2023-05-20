package command;

import repository.UserRepository;
import model.User;
import model.UserRole;
import model.UserStatus;

public class BanUsersCommand {
    public void execute(String userName) {
        User user = UserRepository.findUserByUsername(userName);

        if (UserRole.ADMIN == user.getRole()) {
            System.out.println("this is Admin");
        } else {
            user.setStatus(UserStatus.BAN);
        }
    }
}
