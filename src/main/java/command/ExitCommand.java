package command;

import file.UserToFileWriter;
import service.UserService;

public class ExitCommand {
    private final UserService userService = new UserService();

    public void execute() {
        UserToFileWriter userToFileWriter = new UserToFileWriter();
        userToFileWriter.write(userService.getAllUsers());

        System.exit(0);
    }
}
