import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserContainer {

    static ArrayList<User> infoUser = new ArrayList();
   private final static Map<String, String> users = new HashMap<String, String>();

public void containerSave() {
    User user = new User();
    infoUser.add(user);

}



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
