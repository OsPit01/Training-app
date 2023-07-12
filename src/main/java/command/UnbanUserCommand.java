package command;

import exception.UserNotFoundException;
import model.User;
import model.UserStatus;
import repository.UserRepository;

public class UnbanUserCommand {
    private final UserRepository userRepository = new UserRepository();

    public void execute(long id) throws UserNotFoundException {
        User user = userRepository.findUserById(id);
        user.setStatus(UserStatus.ACTIVE);
        System.out.println("user is active already");
    }
}
