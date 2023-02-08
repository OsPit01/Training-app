
public class RegisterCommand {
    public void register(String userName, String userPassword) {

        UserContainer.getUsers().put(userName, userPassword);
        System.out.println("Registration was successful");

    }
}
