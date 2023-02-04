import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserContainer {


    private static Map<String, String> users = new HashMap<String, String>();

    public static void setMap(Map<String, String> users) {
        UserContainer.users = users;
    }

    public static Map<String, String> getUsers() {
        return users;
    }

    public static boolean isExistsNameAndPassword(String name, String password) {
        boolean existsNameAndPassword = false;

        if (users.containsKey(name) && users.containsValue(password)) {
            existsNameAndPassword = true;
        }
        return existsNameAndPassword;
    }

    public void printUsers() {
        Set<String> list = users.keySet();
        for (String k : list) {
            System.out.print("username" + " " + k + "\n");
        }
    }
}


