package command;

import container.UserContainer;
import model.User;

public class UnbanUserCommand {

    public void unban(String userName) {
        try {
            User user = UserContainer.findUserByUsername(userName);
            assert user != null;
            user.setStatus("active");
            ExitCommand exitCommand = new ExitCommand();
            exitCommand.exit();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
