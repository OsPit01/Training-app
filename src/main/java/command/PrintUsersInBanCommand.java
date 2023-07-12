package command;

import service.UserService;

public class PrintUsersInBanCommand {
    private final UserService userService = new UserService();

    public void printUsersInBan() {
        System.out.println(userService.getUsersInBan());
    }
}
