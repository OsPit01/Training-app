
public class LoginCommand {
    public void execute(String userName, String Password) throws UserNotFoundException {

        if (UserContainer.isUserNameAndPasswordExists(userName, Password)) {
            System.out.println("\n" + "Successful entry");
        } else {
        }
    }
}
