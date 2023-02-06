import java.util.Set;

public class PrintUsers {
    public static void printUsers() {

        Set<String> userNames = UserContainer.getUsers().keySet();
        for (String reveive : userNames) {
            System.out.print("username" + " " + reveive + "\n");
        }
    }
}