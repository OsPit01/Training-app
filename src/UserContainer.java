import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserContainer {

    private final  static List<User> users = new ArrayList();

    public static List<User> getInfoUser() {
        return users;
    }

    public static boolean isUserNameAndPasswordExists(String username, String password) {
        boolean existUser = false;
        int index = users.indexOf(username);

        if(users.get(index +1).toString().contains(password)) {
            existUser = true;
        }
        return existUser;
    }
}
