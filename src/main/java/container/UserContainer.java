package container;

import exception.UserNotFoundException;
import model.Admin;
import model.Trainee;
import model.Trainer;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserContainer {

    private static final List<User> users = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static void save(User user) {
        users.add(user);
    }

    public static void saveAll(List<User> inputUsers) {
        for (User user : inputUsers) {
            users.add(user);
        }
    }

    public static boolean isUserNameAndPasswordExists(String userName, String password) throws UserNotFoundException {
        boolean existUser = false;
        User foundUser;

        for (int i = 0; i < users.size(); i++) {
            foundUser = users.get(i);
            if (foundUser.getUsername().equals(userName) && foundUser.getPassword().equals(password)) {
                existUser = true;
                isUserRole(foundUser);
            }
        }
        if (!existUser) {
            throw new UserNotFoundException("such username or password does not exist");
        }
        return existUser;
    }

    public static void isUserRole(User user) {

        if (user.getRole().equals("admin")) {
            System.out.println("\n" + "you have successfully logged in as admin");
            Admin admin = new Admin();
            admin.isCommand(user.getRole());
        }
        if (user.getRole().equals("trainee")) {
            System.out.println("\n" + "Successful entry");
            Trainee trainee = new Trainee();
            trainee.isCommand();
        }
        if (user.getRole().equals("trainer")) {
            System.out.println("\n" + "Successful entry");
            Trainer trainer = new Trainer(user.getName(),user.getUsername());
            trainer.isCommand();
        }

    }
}
