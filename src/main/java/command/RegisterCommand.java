package command;

import repository.UserRepository;
import model.User;
import model.UserRole;
import model.UserStatus;

public class RegisterCommand {

    public void register(String createUserName, String createPassword, String name, String surname, UserRole role) {
        User user = new User(createUserName, createPassword, name, surname, role, UserStatus.ACTIVE);
        UserRepository.save(user);
        System.out.println("Registration was successful");
    }
}
