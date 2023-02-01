
    import java.util.Scanner;

    public class Login {
        String userName;
        String password;

        public Login(String userName,String password) {
            this.userName = userName;
            this.password = password;
            if (UserContainer.isNameExists(userName,password)) {
                System.out.println("\n" + "Successful entry");
            }
            else {
                System.out.println("wrong username or password");
            }
        }

    }

