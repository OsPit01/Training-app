package service;

import exception.LoginException;
import exception.UserNotFoundException;
import model.User;
import model.UserStatus;
import repository.UserRepository;
import repository.UserSession;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public void login(String username, String password) throws LoginException {

        try {
            User foundUser = UserRepository.findUserByUsernameAndPassword(username, password);
            if (isActive(foundUser)) {
                UserSession.currentUser = foundUser;
            }
            if (!isActive(foundUser)) {
                throw new LoginException("you are blocked");
            }
        } catch (UserNotFoundException e) {
            throw new LoginException("Login error");
        }
    }

    public boolean isUserExists(String username) {
        try {
            UserRepository.findUserByUsername(username);
            return true;
        } catch (UserNotFoundException e) {
            return false;
        }
    }

    public boolean isActive(User user) {
        return UserStatus.ACTIVE == user.getStatus();
    }

    public List<User> getUsersInBan() {
        List<User> result = new ArrayList<>();
        List<User> findUserByStatus = UserRepository.getUsers();
        for (User user : findUserByStatus) {
            if (UserStatus.BAN == user.getStatus()) {
                result.add(user);
            }
        }
        return result;
    }
}
