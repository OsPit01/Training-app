import command.*;
import command.constant.CommandConstants;
import file.UserFromFileReader;
import model.User;
import model.UserRole;
import repository.UserRepository;
import repository.UserSession;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void init() {
        UserFromFileReader fileReader = new UserFromFileReader();
        List<User> fileUsers = fileReader.read();
        UserRepository.saveAll(fileUsers);
    }

    public static void main(String[] args) throws Exception {
        init();

        //noinspection InfiniteLoopStatement
        while (true) {

            MenuPrinter menuPrinter = new MenuPrinter();
            menuPrinter.print(UserRole.GHOST);
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case CommandConstants.LOGIN_CODE -> {
                    System.out.println("Your username");
                    String inputUsername = scanner.nextLine();
                    System.out.println("password");
                    String inputPassword = scanner.nextLine();
                    LoginCommand loginCommand = new LoginCommand();
                    loginCommand.execute(inputUsername, inputPassword);
                    menuPrinter.print(UserSession.currentUser.getRole());
                }
                case CommandConstants.REGISTER_CODE -> {
                    System.out.println("Create your account");
                    System.out.println("Your userName");
                    String createUserName = scanner.nextLine();
                    System.out.println("create password ");
                    String createPassword = scanner.nextLine();
                    System.out.println("\ninput your name");
                    String createName = scanner.nextLine();
                    System.out.println("\ninput your surname");
                    String createSurname = scanner.nextLine();
                    System.out.println("your role");
                    String inputRole = scanner.nextLine();
                    UserRole createRole = UserRole.valueOf(inputRole.toUpperCase());
                    new RegisterCommand().
                            execute(createUserName, createPassword, createName, createSurname, createRole);
                }
                case CommandConstants.EXIT_CODE -> {
                    ExitCommand exitCommand = new ExitCommand();
                    exitCommand.execute();
                }
                case CommandConstants.SHOW_ME_LIST_CODE -> {
                    PrintUsersCommand printUsersCommand = new PrintUsersCommand();
                    printUsersCommand.print();
                }
                case CommandConstants.BAN_USER -> {
                    if (UserSession.currentUser.getRole().equals(UserRole.ADMIN)) {
                        System.out.println("write name of user for ban");
                        String userName = scanner.nextLine();
                        BanUsersCommand banUsersCommand = new BanUsersCommand();
                        banUsersCommand.execute(userName);
                    }
                }
                case CommandConstants.UNBAN -> {
                    User currentUser = UserSession.currentUser;
                    if (UserRole.ADMIN == currentUser.getRole()) {
                        UserRepository.getUserInBan();
                        System.out.println("write name of user for unban");
                        String userName = scanner.nextLine();
                        UnbanUserCommand unbanUserCommand = new UnbanUserCommand();
                        unbanUserCommand.execute(userName);
                    }
                }
                case CommandConstants.SHOW_USERS_IN_BAN -> {
                    User currentUser = UserSession.currentUser;
                    if (UserRole.ADMIN == currentUser.getRole()) {
                        UserRepository.getUserInBan();
                    }
                }
            }
        }
    }
}
