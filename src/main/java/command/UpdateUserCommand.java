package command;

import exception.UserNotFoundException;
import model.User;
import repository.UserRepository;

public class UpdateUserCommand {
    private final UserRepository userRepository = new UserRepository();

    public void execute(User user) throws UserNotFoundException {
        System.out.println("\ninput new user");
        System.out.println(user);

        User currentUser = userRepository.findUserById(user.getId());

        currentUser.setSurname(user.getSurname());
        currentUser.setPassword(user.getPassword());
        currentUser.setName(user.getName());
        currentUser.setUsername(user.getUsername());
    }
}
