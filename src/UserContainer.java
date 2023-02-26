import java.util.ArrayList;
import java.util.List;

public class UserContainer {
    public static void main(String[] args) throws UserNotFoundException {
        User user = new User("igor", "igor_osipov", "ihar", "osipov");
        User user2 = new User("vlad", "vlad_osipov", "vladislav", "osipov");
        User user3 = new User("filips", "filips_password", "filip", "filipovich");
        save(user);
        save(user2);
        save(user3);
        System.out.println(UserContainer.isUserNameAndPasswordExists(user.getUsername(), user.getPassword()));
        System.out.println(UserContainer.isUserNameAndPasswordExists(user2.getUsername(), user2.getPassword()));
        System.out.println(UserContainer.isUserNameAndPasswordExists(user3.getUsername(), user.getPassword()));

    }


    private static final List<User> users = new ArrayList();

    public static final List<User> getUsers() {
        return users;
    }

    public static void save(User user) {
        users.add(user);
    }

    public static boolean isUserNameAndPasswordExists(String userName, String password) throws UserNotFoundException {
        boolean existUser = false;
        User foundUser;

        for (int i = 0; i < users.size(); i++) {
            foundUser = users.get(i);
            if (foundUser.getUsername().equals(userName) && foundUser.getPassword().equals(password)) {
                existUser = true;
                break;
            }
        }
        if (!existUser) {
            throw new UserNotFoundException("such username or password does not exist");
        }
        return existUser;
    }
}