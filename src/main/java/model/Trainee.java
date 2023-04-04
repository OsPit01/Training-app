package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import command.ExitCommand;
import command.JsonCommand;

import java.util.Scanner;

public class Trainee {
    private static final Scanner scanner = new Scanner(System.in);

    public void isCommand() {
        while (true) {
            System.out.println("press 1: Do show Trainers");
            System.out.println("press 2: do exit");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    try {
                        new JsonCommand().printTrainers();
                        break;
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                case 2:
                    ExitCommand exitCommand = new ExitCommand();
                    exitCommand.exit();

            }
        }
    }
}
