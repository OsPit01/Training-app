package command;

import container.UserContainer;
import model.User;
import model.UserRole;

public class BanUsersCommand {
    public void ban(String userName) {
        try {
            User user = UserContainer.findUserByUsername(userName);
            assert user != null;
            if (user.getRole().equals(UserRole.ADMIN)) {
                System.out.println("this is Admin");
                return;

            } else {
                ExitCommand exitCommand = new ExitCommand();
                user.setStatus("ban");
                exitCommand.exit();
            }
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
