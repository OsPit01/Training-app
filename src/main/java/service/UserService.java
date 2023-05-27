package service;

import exception.LoginCommandException;
import exception.UserNotFoundException;
import model.User;
import model.UserStatus;
import repository.UserRepository;
import repository.UserSession;

public class UserService {

    public void login(String username, String password) throws LoginCommandException {

        try {
            User foundUser = UserRepository.findUserByUsernameAndPassword(username, password);
            if (isActive(foundUser)) {
                UserSession.currentUser = foundUser;
            }
        } catch (UserNotFoundException e) {
            throw new LoginCommandException("you are blocked");
        }

    }

    public boolean isUserExists(String userName) {
        for (User user : UserRepository.getUsers()) {
            if (user.getUsername().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isActive(User user) {
        return user.getStatus() == UserStatus.ACTIVE;
    }
}
