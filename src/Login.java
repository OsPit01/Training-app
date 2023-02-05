
public class Login {
    public void execute(String userName, String userPassword) {
        if (UserContainer.isNameAndPasswordExisits(userName, userPassword)) {
            System.out.println("\n" + "Successful entry");
        } else {
            System.out.println("wrong username or password");
        }
    }
}

