package command;

import exception.UserNotFoundException;
import model.User;
import repository.UserRepository;
import service.UserService;

public class RegisterCommand {
    private final UserService userService = new UserService();

    public void execute(User user) {
        try {
            if (userService.isUserExists(user.getUsername())) {
                System.out.println("such a user exist already");
            }
        } catch (UserNotFoundException e) {
            UserRepository.save(user);
            System.out.println("Registration was successful");
        }
    }
}
