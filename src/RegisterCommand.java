
public class RegisterCommand {
    public void register(String name, String surname, String createUserName, String createPassword) {
        User user = new User(name, surname, createUserName, createPassword);
        UserContainer.getInfoUser().add(user);
        System.out.println("Registration was successful");
    }
}
