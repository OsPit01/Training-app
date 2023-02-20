import java.util.ArrayList;
import java.util.List;

public class UserContainer {

    private final static List<User> users = new ArrayList();

    public final static List<User> getUsers() {
        return users;
    }

    public static boolean isUserNameAndPasswordExists(String userName, String password) throws UserNotFoundException {
        boolean existUser = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(userName)) {
                int index = i;
                if (users.get(index).getPassword().equals(password)) {
                    existUser = true;
                }
                else {
                    throw new UserNotFoundException("User with such login and password is not found");
                }
            }
        }
        return existUser;
    }
}
