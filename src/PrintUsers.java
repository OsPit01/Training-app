import java.util.Set;

public class PrintUsers {
    public void printUsers() {

        Set<String> userNames = UserContainer.getUsers().keySet();
        for (String receive : userNames) {
            System.out.print("username" + " " + receive + "\n");
        }
    }
}
