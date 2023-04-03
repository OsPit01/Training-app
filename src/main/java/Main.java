import command.ExitCommand;
import command.LoginCommand;
import command.PrintUsersCommand;
import command.RegisterCommand;
import command.constant.CommandConstants;
import container.UserContainer;
import file.UserFromFileReader;
import model.Trainee;
import model.Trainer;
import model.User;

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
                    System.out.println("your role");
                    String role = scanner.nextLine();
                    if(role.equals("admin")) {
                        System.out.println("Welcome");
                    }
                    if(role.equals("trainer")) {
                        System.out.println("your age");
                        String age = scanner.nextLine();
                        System.out.println("your weight");
                        String weight = scanner.nextLine();
                        System.out.println("your height");
                        String height = scanner.nextLine();
                        Trainer trainer = new Trainer(age,weight,height);
                    }
                    if (role.equals("trainee")) {
                        System.out.println("your level up");
                        String lvl = scanner.nextLine();
                        Trainee trainee = new Trainee(lvl);

                    }
                    new RegisterCommand().register(createUserName, createPassword, name, surname,role);
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
