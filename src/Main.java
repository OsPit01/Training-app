import java.util.*;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> b = new ArrayList<>();
        b.add("dsfsdgsdg + fdsfsdfdsf + fdsfsdfsd");
        System.out.println(b);

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
                    LoginCommand loginCommand = new LoginCommand();
                    loginCommand.execute(inputName, inputPassword);

                    break;

                case CommandConstants.REGISTER_CODE:
                    System.out.println("Create your account \n");
                    System.out.println("Your userName");
                    String createUserName = scanner.nextLine();
                    System.out.println("create password ");
                    String createPassword = scanner.nextLine();
                    RegisterCommand registerCommand = new RegisterCommand();
                    registerCommand.register(createUserName, createPassword);
                    System.out.println("\ninput your name");
                    String name = scanner.nextLine();
                    System.out.println("\ninput your surname");
                    String surname = scanner.nextLine();
                    User a = new User();
                    a.addInfo(name,surname,createPassword,createPassword);

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
