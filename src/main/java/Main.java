import Ui.MenuPrinter;
import command.*;
import command.constant.CommandConstants;
import file.UserFromFileReader;
import model.User;
import model.UserRole;
import model.UserStatus;
import repository.UserRepository;
import repository.UserSession;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MenuPrinter menuPrinter = new MenuPrinter();

    public static void init() {
        UserFromFileReader fileReader = new UserFromFileReader();
        List<User> fileUsers = fileReader.read();
        UserRepository.saveAll(fileUsers);
        menuPrinter.print(UserRole.GUEST);
    }

    public static void main(String[] args) throws Exception {
        init();

        //noinspection InfiniteLoopStatement
        while (true) {
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
                    String inputUsername = scanner.nextLine();
                    System.out.println("create password ");
                    String inputPassword = scanner.nextLine();
                    System.out.println("\ninput your name");
                    String inputName = scanner.nextLine();
                    System.out.println("\ninput your surname");
                    String inputSurname = scanner.nextLine();
                    System.out.println("your role");
                    String inputRole = scanner.nextLine();
                    UserRole convertToUserRole = UserRole.valueOf(inputRole.toUpperCase());
                    User user = new User(
                            inputUsername,
                            inputPassword,
                            inputName,
                            inputSurname,
                            convertToUserRole,
                            UserStatus.ACTIVE);
                    new RegisterCommand().execute(user);
                }
                case CommandConstants.EXIT_CODE -> {
                    ExitCommand exitCommand = new ExitCommand();
                    exitCommand.execute();
                }
                case CommandConstants.SHOW_ME_LIST_CODE -> {
                    PrintUsersCommand printUsersCommand = new PrintUsersCommand();
                    printUsersCommand.execute();
                }
                case CommandConstants.BAN_USER -> {
                    UserRole currentRole = UserSession.currentUser.getRole();
                    if (currentRole == UserRole.ADMIN) {
                        System.out.println("write name of user for ban");
                        String inputUsername = scanner.nextLine();
                        BanUsersCommand banUsersCommand = new BanUsersCommand();
                        banUsersCommand.execute(inputUsername);
                    }
                }
                case CommandConstants.UNBAN -> {
                    UserRole currentRole = UserSession.currentUser.getRole();
                    if (currentRole == UserRole.ADMIN) {
                        UserRepository.UserInBan();
                        System.out.println("write name of user for unban");
                        String inputUsername = scanner.nextLine();
                        UnbanUserCommand unbanUserCommand = new UnbanUserCommand();
                        unbanUserCommand.execute(inputUsername);
                    }
                }
                case CommandConstants.SHOW_USERS_IN_BAN -> {
                    UserRole currentRole = UserSession.currentUser.getRole();
                    if (currentRole == UserRole.ADMIN) {
                        UserRepository.UserInBan();
                    }
                }
                case CommandConstants.RETURN_MENU -> {
                    MenuPrinter menuPrinter1 = new MenuPrinter();
                    menuPrinter1.print(UserRole.GUEST);
                }
            }
        }
    }
}
