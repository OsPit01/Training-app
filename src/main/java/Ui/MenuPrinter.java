package Ui;

import model.UserRole;

import static command.constant.CommandConstants.*;

public class MenuPrinter {

    public void print(UserRole userRole) {
        switch (userRole) {
            case GUEST -> printForGuest();
            case TRAINEE -> printForTrainee();
            case TRAINER -> printForTrainer();
            case ADMIN -> printForAdmin();
        }
    }

    private void printForAdmin() {
        System.out.println("Admin please do choice");
        System.out.println(String.format("%s -> choice user for ban", BAN_USER));
        System.out.println(String.format("%s -> choice user for unban", UNBAN));
        System.out.println(String.format("%s - return menu", RETURN_MENU));
        System.out.println(String.format("%s -> show users in ban", SHOW_USERS_IN_BAN));
    }

    private void printForTrainer() {
        System.out.println("Trainer please do choice");
        System.out.println(String.format("%s - exit", EXIT_CODE));
        System.out.println(String.format("%s - show me list", SHOW_ME_LIST_CODE));
        System.out.println(String.format("%s.return menu", RETURN_MENU));
    }

    private void printForTrainee() {
        System.out.println("Trainee please do choice");
        System.out.println(String.format("%s - exit", EXIT_CODE));
        System.out.println(String.format("%s - show me list", SHOW_ME_LIST_CODE));
        System.out.println(String.format("%s.return menu", RETURN_MENU));
    }

    private void printForGuest() {
        System.out.println(String.format("%s - Login", LOGIN_CODE));
        System.out.println(String.format("%s - Register", REGISTER_CODE));
        System.out.println(String.format("%s - exit", EXIT_CODE));
        System.out.println(String.format("%s - show me list", SHOW_ME_LIST_CODE));
    }
}
