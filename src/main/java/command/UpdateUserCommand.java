package command;

import exception.UserNotFoundException;
import model.User;
import repository.service.UserService;

public class UpdateUserCommand {
    private final UserService userService = new UserService();

    public void execute(User user) throws UserNotFoundException {
        System.out.println("\ninput new user");
        System.out.println(user);

        User currentUser = userService.getUserById(user.getId());
        currentUser.setSurname(user.getSurname());
        currentUser.setPassword(user.getPassword());
        currentUser.setName(user.getName());
        currentUser.setUsername(user.getUsername());
    }
}
