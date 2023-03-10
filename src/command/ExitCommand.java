package command;

import container.UserContainer;
import file.UserToFileWrite;

public class ExitCommand {
    public void exit() {
        UserToFileWrite userToFileWriter = new UserToFileWrite();
        userToFileWriter.write(UserContainer.getUsers());

        System.exit(0);
    }
}
