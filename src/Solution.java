import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String userName = "";
        String password = "";
        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println("******** Register *********");
            System.out.println("please do choice");
            System.out.println("1.Login 2.Register 3.exit 4.showMe list");
            String choice = scanner.nextLine();

            switch (choice) {
                case Command.LOGIN_CODE:
                    System.out.println("Your name");
                    userName = scanner.nextLine();
                    System.out.println("password");
                    password = scanner.nextLine();
                    Login loginCommand = new Login();
                    loginCommand.excute(userName, password);

                    break;
                case Command.REGISTER_CODE:
                    System.out.println("Create your account \n");
                    System.out.println("Your name");
                    userName = scanner.nextLine();
                    System.out.println("create password ");
                    password = scanner.nextLine();
                    Register register = new Register();
                    register.Registry(userName, password);
                    break;
                case Command.EXIT_CODE:
                    new Exit();
                    break;
                case Command.SHOW_ME_LIST_CODE:
                    new UserContainer().getList();
                    break;
            }
        }
    }
}

