import command.*;
import command.constant.CommandConstants;
import container.UserContainer;
import container.UserSession;
import file.UserFromFileReader;
import model.User;
import model.UserRole;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void init() {
        UserFromFileReader fileReader = new UserFromFileReader();
        List<User> fileUsers = fileReader.read();
        UserContainer.saveAll(fileUsers);
    }

    public static void main(String[] args) throws Exception {
        init();

        while (true) {
            System.out.println("******** Register *********");
            System.out.println("please do choice");
            System.out.println("1.Login 2.Register 3.exit 4.showMe list");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case CommandConstants.LOGIN_CODE -> {
                    System.out.println("Your username");
                    String inputUsername = scanner.nextLine();
                    System.out.println("password");
                    String inputPassword = scanner.nextLine();
                    LoginCommand loginCommand = new LoginCommand();
                    loginCommand.execute(inputUsername, inputPassword, "active");
                    if (UserSession.currentUser.getRole().equals(UserRole.ADMIN)) {
                        System.out.println("1010. choice user for ban" + '\n' + "1011. choice user for unban");
                    }
                }
                case CommandConstants.REGISTER_CODE -> {
                    System.out.println("Create your account");
                    System.out.println("Your userName");
                    String createUserName = scanner.nextLine();
                    if (UserContainer.isUserExists(createUserName)) {
                        System.out.println("such a user exist already");
                        return;
                    }
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
                            register(createUserName, createPassword, createName, createSurname, createRole);
                }
                case CommandConstants.EXIT_CODE -> {
                    ExitCommand exitCommand = new ExitCommand();
                    exitCommand.exit();
                }
                case CommandConstants.SHOW_ME_LIST_CODE -> {
                    PrintUsersCommand printUsersCommand = new PrintUsersCommand();
                    printUsersCommand.print();
                }
                case CommandConstants.BAN_USERS -> {
                    User currentUser = UserSession.currentUser;
                    if (currentUser.getRole().equals(UserRole.ADMIN)) {
                        System.out.println("write name of user for ban");
                        String user = scanner.nextLine();
                        BanUsersCommand banUsersCommand = new BanUsersCommand();
                        banUsersCommand.ban(user);
                    }
                }
                case CommandConstants.UNBAN -> {
                    User currentUser = UserSession.currentUser;
                    if (currentUser.getRole().equals(UserRole.ADMIN)) {
                        UserContainer.showUserInBan();
                        System.out.println("write name of user for unban");
                        String writeForUnban = scanner.nextLine();
                        UnbanUserCommand unbanUserCommand = new UnbanUserCommand();
                        unbanUserCommand.unban(writeForUnban);
                    }
                }
            }
        }
    }
}
