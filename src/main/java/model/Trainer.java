package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import command.ExitCommand;
import command.JsonCommand;

import java.util.Scanner;

public class Trainer {
    String name;
    String surname;
    String height;

    private static final Scanner scanner = new Scanner(System.in);

    public Trainer(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void isCommand() {
        while (true) {
            System.out.println("press 1: Do show Trainee");
            System.out.println("press 2: do exit");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    try {
                        new JsonCommand().printTrainee();
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
