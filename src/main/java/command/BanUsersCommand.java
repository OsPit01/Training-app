package command;

import container.UserContainer;
import model.User;
import model.UserRole;
import model.UserStatus;

public class BanUsersCommand {
    public void execute(String userName) {
        User user = UserContainer.findUserByUsername(userName);

        if (UserRole.ADMIN == user.getRole()) {
            System.out.println("this is Admin");
        } else {
            user.setStatus(UserStatus.BAN);
        }
    }
}
