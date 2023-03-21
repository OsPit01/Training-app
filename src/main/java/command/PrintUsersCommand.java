package command;

import container.UserContainer;

public class PrintUsersCommand {
    public void printUsers() {
        System.out.println(UserContainer.getUsers());
    }
}
