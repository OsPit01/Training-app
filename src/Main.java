import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String userName;
        String password;


        while (true) {

            System.out.println("******** Register *********");
            System.out.println("please do choice");
            System.out.println("1.Login 2.Register 3.exit 4.showMe list");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case CommandConstants.LOGIN_CODE:
                    System.out.println("Your name");
                    userName = scanner.nextLine();
                    System.out.println("password");
                    password = scanner.nextLine();
                    Login loginCommand = new Login();
                    loginCommand.excute(userName, password);

                    break;
                case CommandConstants.REGISTER_CODE:
                    System.out.println("Create your account \n");
                    System.out.println("Your name");
                    userName = scanner.nextLine();
                    System.out.println("create password ");
                    password = scanner.nextLine();
                    Register registerCommand = new Register();
                    registerCommand.registry(userName, password);
                    break;
                case CommandConstants.EXIT_CODE:
                    new Exit();
                    break;
                case CommandConstants.SHOW_ME_LIST_CODE:
                    new UserContainer().printUsers();
                    break;
            }
        }
    }
}
