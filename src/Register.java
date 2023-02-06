
public class Register {
    public void commandRegister(String userName, String userPassword) {

        UserContainer.getUsers().put(userName, userPassword);
        System.out.println("Registration was successful");
    }
}
