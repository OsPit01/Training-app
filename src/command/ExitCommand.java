package command;

import container.UserContainer;
import file.UserToFileWriter;

public class ExitCommand {
    public void exit() {
        UserToFileWriter userToFileWriter = new UserToFileWriter();
        userToFileWriter.write(UserContainer.getUsers());

        System.exit(0);
    }
}
