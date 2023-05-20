package command;

import container.UserContainer;
import model.User;
import model.UserStatus;

public class UnbanUserCommand {

    public void execute(String userName) {
        User user = UserContainer.findUserByUsername(userName);
        user.setStatus(UserStatus.ACTIVE);

    }
}
