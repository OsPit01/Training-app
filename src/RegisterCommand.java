
public class RegisterCommand {
    public void register(String userName, String userPassword) {

        UserContainer.getUsers().put(userName, userPassword);
        System.out.println("Registration was successful");
        System.out.println("input your name");

    }
}
