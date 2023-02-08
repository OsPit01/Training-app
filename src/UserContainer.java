import java.util.HashMap;
import java.util.Map;

public class UserContainer {
   private final static Map<String, String> users = new HashMap<String, String>();

    public static Map<String, String> getUsers() {
        return users;
    }

    public static boolean isUserNameAndPasswordExists(String userName, String password) {
        boolean userExists = false;

        if (users.containsKey(userName) && users.containsValue(password)) {
            userExists = true;
        }
        return userExists;
    }

}
