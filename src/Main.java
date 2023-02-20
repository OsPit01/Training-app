import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("******** Register *********");
            System.out.println("please do choice");
            System.out.println("1.Login 2.Register 3.exit 4.showMe list");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case CommandConstants.LOGIN_CODE:
                    System.out.println("Your username");
                    String inputUsername = scanner.nextLine();
                    System.out.println("password");
                    String inputPassword = scanner.nextLine();
                    LoginCommand loginCommand = new LoginCommand();
                    loginCommand.execute(inputUsername, inputPassword);
                    break;

                case CommandConstants.REGISTER_CODE:
                    System.out.println("Create your account");
                    System.out.println("Your userName");
                    String createUserName = scanner.nextLine();
                    if (UserContainer.getUsers().toString().contains(createUserName)) {
                        System.out.println("such a user exist already");
                        return;
                    }
                    System.out.println("create password ");
                    String createPassword = scanner.nextLine();
                    System.out.println("\ninput your name");
                    String name = scanner.nextLine();
                    System.out.println("\ninput your surname");
                    String surname = scanner.nextLine();
                    new RegisterCommand().register(createUserName, createPassword, name, surname);
                    break;

                case CommandConstants.EXIT_CODE:
                    ExitCommand exitCommand = new ExitCommand();
                    exitCommand.exit();
                    break;

                case CommandConstants.SHOW_ME_LIST_CODE:
                    PrintUsersCommand printUsersCommand = new PrintUsersCommand();
                    printUsersCommand.printUsers();
                    break;
            }
        }
    }
}
