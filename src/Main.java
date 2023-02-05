import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("******** Register *********");
            System.out.println("please do choice");
            System.out.println("1.Login 2.Register 3.exit 4.showMe list");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case CommandConstants.LOGIN_CODE:
                    System.out.println("Your name");
                    String existName = scanner.nextLine();
                    System.out.println("password");
                    String existPassword = scanner.nextLine();
                    Login loginCommand = new Login();
                    loginCommand.execute(existName, existPassword);
                    break;

                case CommandConstants.REGISTER_CODE:
                    System.out.println("Create your account \n");
                    System.out.println("Your name");
                    String creatUserName = scanner.nextLine();
                    System.out.println("create password ");
                    String creatPassword = scanner.nextLine();
                    Register registerCommand = new Register();
                    registerCommand.registr(creatUserName,creatPassword);
                    break;

                case CommandConstants.EXIT_CODE:
                    new Exit().exit();
                    break;

                case CommandConstants.SHOW_ME_LIST_CODE:
                    new UserContainer().printUsers();
                    break;
            }
        }
    }
}
