package service;

import exception.LoginCommandException;
import exception.UserNotFoundException;
import model.User;
import model.UserStatus;
import repository.UserRepository;
import repository.UserSession;

import java.util.ArrayList;
import java.util.List;

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

    public boolean isUserExists(String userName) throws UserNotFoundException {
        User result = UserRepository.findUserByUsername(userName);
        return result.getUsername().equals(userName);
    }

    public boolean isActive(User user) {
        return user.getStatus() == UserStatus.ACTIVE;
    }

    public List<User> getListUserInBan() {
        List<User> result = new ArrayList<>();
        for (User user : UserRepository.getUsers()) {
            if (user.getStatus().equals(UserStatus.BAN)) {
                result.add(user);
            }
        }
        return result;
    }
}
