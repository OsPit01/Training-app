
public class RegisterCommand {
    public void register(String userName, String userPassword) {

        UserContainerCommand.getUsers().put(userName, userPassword);
        System.out.println("Registration was successful");
    }
}
