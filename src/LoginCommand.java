
public class LoginCommand {
    public void execute(String userName, String Password) {

        if (UserContainer.isUserNameAndPasswordExists(userName,Password)) {
            System.out.println("\n" + "Successful entry");
        } else {
            System.out.println("wrong username or password");
        }
    }
}
