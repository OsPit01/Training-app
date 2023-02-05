import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserContainer {
    private static Map<String, String> users = new HashMap<String, String>();

    public static void setMap(Map<String, String> setNameUsers) {
        UserContainer.users = setNameUsers;
    }

    public static Map<String, String> getUsers() {
        return users;
    }

    public static boolean isNameAndPasswordExisits(String name, String password) {
        boolean existsNameAndPassword = false;

        if (users.containsKey(name) && users.containsValue(password)) {
            existsNameAndPassword = true;
        }
        return existsNameAndPassword;
    }

    public static void printUsers() {
        Set<String> userNames = users.keySet();
        for (String reveive : userNames) {
            System.out.print("username" + " " + reveive + "\n");
        }
    }
}