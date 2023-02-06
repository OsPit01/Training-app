import java.util.HashMap;
import java.util.Map;

public class UserContainer {
    private static Map<String, String> users = new HashMap<String, String>();

    public static void setMap(Map<String, String> setNameUsers) {
        UserContainer.users = setNameUsers;
    }

    public static Map<String, String> getUsers() {
        return users;
    }

    public static boolean isUserNameAndPasswordExisits(String name, String password) {
        boolean isUserNameAndPasswordExisits = false;

        if (users.containsKey(name) && users.containsValue(password)) {
            isUserNameAndPasswordExisits= true;
        }
        return isUserNameAndPasswordExisits;
    }
}