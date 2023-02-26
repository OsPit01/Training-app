
public class LoginCommand {
    public void execute(String userName, String Password) {

        try {
            if (UserContainer.isUserNameAndPasswordExists(userName, Password)) {
                System.out.println("\n" + "Successful entry");
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            System.out.println("try to enter the correct username and password");

        }
    }

}
