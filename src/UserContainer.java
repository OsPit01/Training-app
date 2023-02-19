import java.util.ArrayList;
import java.util.List;

public class UserContainer extends UserNotFoundException {

    private static final List<User> users = new ArrayList();

    public static final List<User> getUsers() {
        return users;
    }

    public static boolean isUserNameAndPasswordExists(String userName, String password) throws UserNotFoundException {
        boolean existUser = false;
        int index = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(userName)) {
                index = users.indexOf(users.get(i));
                break;
            }
        }
        if (users.get(index).getPassword().equals(password)) {
            existUser = true;
        } else {
            throw new UserNotFoundException("«User with such login and password is not found»");

        }
        return existUser;
    }
}
