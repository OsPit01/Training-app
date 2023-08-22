import command.*;
import command.constant.CommandConstants;
import converter.JsonToUserConverter;
import file.UserFromFileReader;
import model.User;
import model.UserRole;
import model.UserStatus;
import repository.UserRepository;
import repository.UserSession;
import repository.service.UserService;
import ui.MenuPrinter;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static final MenuPrinter menuPrinter = new MenuPrinter();

    private static final UserRepository userRepository = new UserRepository();

    private static final JsonToUserConverter jsonToUserConverter = new JsonToUserConverter();


    public static void init() {
        UserFromFileReader fileReader = new UserFromFileReader();
        List<User> fileUsers = fileReader.read();
        userRepository.saveAll(fileUsers);
        User.setCounter(userRepository.findLastId());
    }

    public static void main(String[] args) throws Exception {
        init();
        //noinspection InfiniteLoopStatement
        while (true) {
            menuPrinter.print();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case CommandConstants.LOGIN_CODE -> {
                    System.out.println("Your username");
                    String inputUsername = scanner.nextLine();
                    System.out.println("password");
                    String inputPassword = scanner.nextLine();
                    LoginCommand loginCommand = new LoginCommand();
                    loginCommand.execute(inputUsername, inputPassword);
                }
                case CommandConstants.REGISTER_CODE -> {
                    System.out.println("Create your account");
                    System.out.println("Your username");
                    String inputUsername = scanner.nextLine();
                    System.out.println("your email");

                    String inputEmail = scanner.nextLine();
                    System.out.println("\ninput your name");
                    String inputName = scanner.nextLine();
                    System.out.println("\ninput your surname");
                    String inputSurname = scanner.nextLine();
                    System.out.println("your role");
                    String inputRole = scanner.nextLine();
                    UserRole inputUserRole = UserRole.valueOf(inputRole.toUpperCase());
                    User user = new User(
                            inputUsername,
                            inputName,
                            inputSurname,
                            inputUserRole,
                            UserStatus.ACTIVE,
                            inputEmail
                    );
                    RegisterCommand registerCommand = new RegisterCommand();
                    registerCommand.execute(user);
                }
                case CommandConstants.EXIT_CODE -> {
                    ExitCommand exitCommand = new ExitCommand();
                    exitCommand.execute();
                }
                case CommandConstants.SHOW_ME_LIST_CODE -> {
                    ShowMeListCommand showMeListCommand = new ShowMeListCommand();
                    showMeListCommand.execute();
                }
                case CommandConstants.BAN_USER -> {
                    UserRole currentRole = UserSession.currentUser.getRole();
                    if (UserRole.ADMIN == currentRole) {
                        System.out.println("write id of user for ban");
                        long id = Integer.parseInt(scanner.nextLine());
                        BanUsersCommand banUsersCommand = new BanUsersCommand();
                        banUsersCommand.execute(id);
                    }
                }
                case CommandConstants.UNBAN -> {
                    UserRole currentRole = UserSession.currentUser.getRole();
                    if (UserRole.ADMIN == currentRole) {
                        UserService userService = new UserService();
                        PrintUsersCommand printUsersCommand = new PrintUsersCommand();
                        printUsersCommand.execute(userService.getUsersInBan());
                        System.out.println("write id of user for unban");
                        long id = Integer.parseInt(scanner.nextLine());
                        UnbanUserCommand unbanUserCommand = new UnbanUserCommand();
                        unbanUserCommand.execute(id);
                    }
                }
                case CommandConstants.SHOW_USERS_IN_BAN -> {
                    UserRole currentRole = UserSession.currentUser.getRole();
                    if (UserRole.ADMIN == currentRole) {
                        PrintUsersInBanCommand printUsersInBanCommand = new PrintUsersInBanCommand();
                        printUsersInBanCommand.printUsersInBan();
                    }
                }
                case CommandConstants.UPDATE_USER_COMMAND -> {
                    System.out.println("\ninput new user");

                    User user = jsonToUserConverter.convert(scanner.nextLine());
                    System.out.println(user);

                    UpdateUserCommand updateUserCommand = new UpdateUserCommand();
                    updateUserCommand.execute(user);
                }
            }
        }
    }
}
