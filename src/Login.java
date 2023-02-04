

    public class Login {


        public void excute(String setName,String setPassword) {
 if (UserContainer.isExistsNameAndPassword(setName,setPassword)) {
     System.out.println("\n" + "Successful entry");
 }
 else {
     System.out.println("wrong username or password");
 }
        }

    }

