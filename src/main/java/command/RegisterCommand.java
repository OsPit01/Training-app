package command;

import container.UserContainer;
import model.User;
import model.UserRole;

public class RegisterCommand {

    public void register(String createUserName, String createPassword, String name, String surname, String role) {
        UserRole trueRole = UserRole.TRAINEE;
        if (role.equalsIgnoreCase("admin")) {
            trueRole = UserRole.ADMIN;
        }
        if (role.equalsIgnoreCase("trainer")) {
            trueRole = UserRole.TRAINER;
        }
        User user = new User(createUserName, createPassword, name, surname,trueRole);
        UserContainer.save(user);
        System.out.println("Registration was successful");
    }
}
