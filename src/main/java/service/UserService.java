package service;

import exception.LoginException;
import exception.UserNotFoundException;
import model.User;
import model.UserStatus;
import repository.UserRepository;
import repository.UserSession;

import java.util.List;

public class UserService {

    public void login(String username, String password) throws LoginException {

        try {
            User foundUser = UserRepository.findUserByUsernameAndPassword(username, password);
            UserSession.currentUser = foundUser;
            if (!isActive(foundUser)) {
                throw new LoginException("you are blocked");
            }
            UserSession.currentUser = foundUser;
        } catch (UserNotFoundException e) {
            throw new LoginException("Login error", e);
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
        return UserRepository.findUsersByStatus(UserStatus.BAN);
    }
}
