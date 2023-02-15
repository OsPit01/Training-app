
public class RegisterCommand {
    public void register(String createUserName, String createPassword, String name, String surname) {
        User user = new User(createUserName,createPassword, name,surname);
        UserContainer.getUsers().add(user);
        System.out.println("Registration was successful");
    }
}
