import java.util.ArrayList;
import java.util.List;

public class UserContainer {

    private static final List<User> users = new ArrayList();

    public static final List<User> getUsers() {
        return users;
    }

    public static boolean isUserNameAndPasswordExists(String userName, String password) throws UserNotFoundException {
        boolean existUser = false;
        for (int i = 0; i < users.size(); i++) {
            User foundUser = users.get(i);
            if (foundUser.getUsername().equals(userName)) {
                if (foundUser.getPassword().equals(password)) {
                    existUser = true;
                } else {
                    throw new UserNotFoundException("User with such login and password is not found");
                }
            }
        }
        return existUser;

    }
}