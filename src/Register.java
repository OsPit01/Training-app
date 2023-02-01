import java.util.Scanner;


    public class Register {
        String userName;
        String password;

        public Register(String userName,String password) {
            this.userName = userName;
            this.password = password;
            UserContainer.map.put(userName,password);
            System.out.println("Registration was successful");

        }
    }

