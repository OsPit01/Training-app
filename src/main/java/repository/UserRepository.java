package repository;

import exception.UserNotFoundException;
import model.User;
import model.UserRole;
import model.UserStatus;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static final List<User> users = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static void save(User user) {
        users.add(user);
    }

    public static void saveAll(List<User> inputUsers) {
        users.addAll(inputUsers);
    }

    public static User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException {

        for (User user : users) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }

    public static User findUserByUsername(String username) throws UserNotFoundException {

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }

    public static List<User> findUsersByRole(List<UserRole> roles) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (roles.contains(user.getRole())) {
                result.add(user);
            }
        }
        return result;
    }

    public static List<User> findUserByStatus() {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (UserStatus.BAN == user.getStatus()) {
                result.add(user);
            }
        }
        return result;
    }
}
