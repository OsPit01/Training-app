
    import java.util.Scanner;

    public class Login {


        public void excute(String setName,String setPassword) {
 if (UserContainer.isNameExists(setName,setPassword)) {
     System.out.println("\n" + "Successful entry");
 }
 else {
     System.out.println("wrong username or password");
 }
        }

    }

