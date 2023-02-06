
public class Login {
    public void commandExecute(String userName, String userPassword) {
        if (UserContainer.isUserNameAndPasswordExisits(userName, userPassword)) {
            System.out.println("\n" + "Successful entry");
        } else {
            System.out.println("wrong username or password");
        }
    }
}
