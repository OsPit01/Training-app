package command;

import container.UserContainer;
import model.User;

public class RegisterCommand {

    public void register(String createUserName, String createPassword, String name, String surname,String role) {
        User user = new User(createUserName, createPassword, name, surname,role);
        UserContainer.save(user);
        System.out.println("Registration was successful");
    }
}
