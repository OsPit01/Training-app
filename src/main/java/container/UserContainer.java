package container;

import exception.UserNotFoundException;
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
                break;
            }
        }
        if (!existUser) {
            throw new UserNotFoundException("such username or password does not exist");
        }
        return existUser;
    }
}
