package container;

import exception.UserNotFoundException;
import model.User;
import model.UserRole;
import model.UserStatus;

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
        users.addAll(inputUsers);
    }

    public static User findUserByUsernameAndPassword(String userName, String password) {

        for (User user : users) {
            if (user.getUsername().equals(userName)
                    && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static User findUserByUsername(String userName) {
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public static boolean isUserNameAndPasswordExists(String userName, String password)
            throws UserNotFoundException {

        boolean existUser = false;
        User foundUser = findUserByUsernameAndPassword(userName, password);

        if (foundUser != null) {
            existUser = true;
        }
        if (foundUser != null) {
            existUser = checkStatus(foundUser);
        }
        if (!existUser) {
            throw new UserNotFoundException("You are blocked");
        }
        return true;
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

    public static void showUserInBan() {
        for (User user : users) {
            if (user.getStatus().equals(UserStatus.BAN)) {
                System.out.println(user);
            }
        }
    }

    public static boolean isUserExists(String userName) {
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkStatus(User user) {
        return user.getStatus() == UserStatus.ACTIVE;
    }
}
