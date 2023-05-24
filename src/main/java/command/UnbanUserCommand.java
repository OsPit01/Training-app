package command;

import exception.UserNotFoundException;
import model.User;
import model.UserStatus;
import repository.UserRepository;

public class UnbanUserCommand {

    public void execute(String userName) throws UserNotFoundException {
        User user = UserRepository.findUserByUsername(userName);
        user.setStatus(UserStatus.ACTIVE);
        System.out.println("user is active already");
    }
}
