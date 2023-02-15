import java.util.ArrayList;
import java.util.List;

public class UserContainer {

    private final static List<User> users = new ArrayList();

    public final static List<User> getUsers() {
        return users;
    }

    public static boolean isUserNameAndPasswordExists(String userName, String password) {
        boolean existUser = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(userName)) {
                if (users.get(i).getPassword().equals(password)) {
                    existUser = true;
                }
            }
        }
        return existUser;
    }
}
