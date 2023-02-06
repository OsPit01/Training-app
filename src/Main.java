import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("******** Register *********");
            System.out.println("please do choice");
            System.out.println("1.Login 2.Register 3.exit 4.showMe list");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case CommandConstants.LOGIN_CODE:
                    System.out.println("Your name");
                    String inputName = scanner.nextLine();
                    System.out.println("password");
                    String inputPassword = scanner.nextLine();
                    Login loginCommand = new Login();
                    loginCommand.execute(inputName, inputPassword);
                    break;

                case CommandConstants.REGISTER_CODE:
                    System.out.println("Create your account \n");
                    System.out.println("Your name");
                    String createUserName = scanner.nextLine();
                    System.out.println("create password ");
                    String createPassword = scanner.nextLine();
                    Register registerCommand = new Register();
                    registerCommand.registr(createUserName, createPassword);
                    break;

                case CommandConstants.EXIT_CODE:
                    new Exit().exit();
                    break;

                case CommandConstants.SHOW_ME_LIST_CODE:
                    PrintUsers.printUsers();
                    break;
            }
        }
    }
}