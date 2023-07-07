package repository;

import exception.UserNotFoundException;
import model.User;
import model.UserRole;
import model.UserStatus;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

   private static List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }

    public void saveAll(List<User> inputUsers) {
        users.addAll(inputUsers);
    }

    public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException {

        for (User user : users) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }

    public User findUserByUsername(String username) throws UserNotFoundException {

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }

    public List<User> findUsersByRole(List<UserRole> roles) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (roles.contains(user.getRole())) {
                result.add(user);
            }
        }
        return result;
    }

    public List<User> findUsersByStatus(UserStatus status) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (status == user.getStatus()) {
                result.add(user);
            }
        }
        return result;
    }

    public User findUserById(long id) throws UserNotFoundException {
        for (User user:users) {
            if (id == user.getId()) {
              return user;
            }
        }
        throw new UserNotFoundException();
    }
    public long findAll() {
        long result = 0;

        for (User user : users) {
            long currentId = user.getId();
            if (currentId > result) {
                result = currentId;
            }
        }
        return result;
    }
}
