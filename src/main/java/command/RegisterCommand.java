package command;

import Service.UserService;
import model.User;
import model.UserRole;
import model.UserStatus;
import repository.UserRepository;

public class RegisterCommand {
    private final UserService userService = new UserService();

    public void execute(String createUserName, String createPassword, String name, String surname, UserRole role) {
        if (userService.isUserExists(createUserName)) {
            System.out.println("such a user exist already");
            return;
        }
        User user = new User(createUserName, createPassword, name, surname, role, UserStatus.ACTIVE);
        UserRepository.save(user);
        System.out.println("Registration was successful");
    }
}
