package command;

import Ui.MenuPrinter;
import model.User;
import model.UserRole;
import repository.UserRepository;
import service.UserService;

public class RegisterCommand {
    private final UserService userService = new UserService();

    public void execute(User user) {
        if (userService.isUserExists(user.getUsername())) {
            System.out.println("such a user exist already");
            return;
        }
        UserRepository.save(user);
        System.out.println("Registration was successful");
        MenuPrinter menuPrinter = new MenuPrinter();
        menuPrinter.print(UserRole.GUEST);
    }
}
