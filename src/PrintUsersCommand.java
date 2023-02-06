import java.util.Set;

public class PrintUsersCommand {
    public void printUsers() {

        Set<String> userNames = UserContainerCommand.getUsers().keySet();
        for (String userName : userNames) {
            System.out.print("username" + " " + userName  + "\n");
        }
    }
}
