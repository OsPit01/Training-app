package Service;

import exception.UserNotFoundException;
import model.User;
import model.UserStatus;
import repository.UserRepository;

public class UserService {

    public boolean isUserNameAndPasswordExists(String username,String password) throws UserNotFoundException {

            boolean existUser = false;
            User foundUser = UserRepository.findUserByUsernameAndPassword(username, password);

            if (foundUser != null) {
                existUser = true;
            }
            if (foundUser != null) {
                existUser = isStatus(foundUser);
            }
            if (!existUser) {
                throw new UserNotFoundException("You are blocked");
            }
            return true;

    }
    public static boolean isUserExists(String userName) {
        for (User user : UserRepository.getUsers()) {
            if (user.getUsername().equals(userName)) {
                return true;
            }
        }
        return false;
    }
    public boolean isStatus(User user) {
        return user.getStatus() == UserStatus.ACTIVE;
    }
}
