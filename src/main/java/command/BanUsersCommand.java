package command;

import container.UserContainer;
import model.User;
import model.UserRole;

public class BanUsersCommand {
    public void ban(String userName) {
        User user = UserContainer.findUserByUsername(userName);
        if (user.getRole().equals(UserRole.ADMIN)) {
            System.out.println("this is Admin");
        } else {
            ExitCommand exitCommand = new ExitCommand();
            user.setStatus("ban");
            exitCommand.exit();
        }
    }
}
