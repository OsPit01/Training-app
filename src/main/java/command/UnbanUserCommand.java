package command;

import repository.UserRepository;
import model.User;
import model.UserStatus;

public class UnbanUserCommand {

    public void execute(String userName) {
        User user = UserRepository.findUserByUsername(userName);
        user.setStatus(UserStatus.ACTIVE);

    }
}
