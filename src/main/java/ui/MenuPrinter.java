package ui;

import repository.UserSession;

import static command.constant.CommandConstants.*;

public class MenuPrinter {

    public void print() {
        if (UserSession.currentUser == null) {
            printForGuest();
            return;
        }
        switch (UserSession.currentUser.getRole()) {
            case TRAINEE -> printForTrainee();
            case TRAINER -> printForTrainer();
            case ADMIN -> printForAdmin();
        }
    }

    private void printForAdmin() {
        System.out.println("Admin please do choice");
        System.out.println(String.format("%s -> choice user for ban", BAN_USER));
        System.out.println(String.format("%s -> choice user for unban", UNBAN));
        System.out.println(String.format("%s -> show users in ban", SHOW_USERS_IN_BAN));
        System.out.println(String.format("%s - change password,", CHANGE_PASSWORD));
    }

    private void printForTrainer() {
        System.out.println("Trainer please do choice");
        System.out.println(String.format("%s - exit", EXIT_CODE));
        System.out.println(String.format("%s - show me list", SHOW_ME_LIST_CODE));
        System.out.println(String.format("%s - change password,", CHANGE_PASSWORD));
    }

    private void printForTrainee() {
        System.out.println("Trainee please do choice");
        System.out.println(String.format("%s - exit", EXIT_CODE));
        System.out.println(String.format("%s - show me list", SHOW_ME_LIST_CODE));
        System.out.println(String.format("%s - change password,", CHANGE_PASSWORD));
    }

    private void printForGuest() {
        System.out.println(String.format("%s - Login", LOGIN_CODE));
        System.out.println(String.format("%s - Register", REGISTER_CODE));
        System.out.println(String.format("%s - exit", EXIT_CODE));
    }
}
