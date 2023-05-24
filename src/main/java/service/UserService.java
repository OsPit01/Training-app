package service;

import exception.UserNotFoundException;
import model.User;
import model.UserStatus;
import repository.UserRepository;

public class UserService {

    public boolean login(String username, String password) throws UserNotFoundException {
            boolean existUser = false;
            User foundUser = UserRepository.findUserByUsernameAndPassword(username, password);

            if (foundUser != null) {
                existUser = isActive(foundUser);
            }

            if (!existUser) {
                throw new UserNotFoundException("You are blocked");
            }
            return true;

    }
    public  boolean isUserExists(String userName) {
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
