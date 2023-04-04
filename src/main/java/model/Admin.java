package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import command.ExitCommand;
import command.JsonCommand;

import java.util.Scanner;

public class Admin {

    private static final Scanner scanner = new Scanner(System.in);

    public void isCommand(String role) {
        while (true) {
            System.out.println("press 1: Do show users");
            System.out.println("press 2: do exit");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    try {
                        new JsonCommand().printAllUsers();
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
