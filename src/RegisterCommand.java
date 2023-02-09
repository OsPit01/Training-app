
public class RegisterCommand {
    public void register(String userName, String userPassword) {
        UserContainer.getUsers().put(userName,userPassword);
      System.out.println("Registration was successful");



       // User addUser = new User();
      //  addUser.addInfo(userName,userPassword,name,surname);
       // System.out.println("Registration was successful");
      //  UserContainer userContainer = new UserContainer();
       // userContainer.getInfoUser().add(addUser.getLogin() +  addUser.getName() + addUser.surname + addUser.getPassword() + addUser.id);
       // System.out.println(userContainer.getInfoUser());

    }
}
