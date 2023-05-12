package command;

import container.UserContainer;
import model.User;
import model.UserRole;

public class RegisterCommand {

    public void register(String createUserName, String createPassword, String name, String surname, UserRole role) {
        User user = new User(createUserName, createPassword, name, surname, role, "active");
        UserContainer.save(user);
        System.out.println("Registration was successful");
    }
}
