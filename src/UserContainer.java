import java.util.ArrayList;
import java.util.List;

public class UserContainer {

    private final  static List<User> users = new ArrayList();

    public static List<User> getInfoUser() {
        return users;
    }
}
