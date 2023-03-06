package command;

import container.UserContainer;
import file.UserToFileWriter;

import java.io.IOException;

public class ExitCommand {

    public void exit() throws IOException {

        UserToFileWriter userToFileWriter = new UserToFileWriter();
        userToFileWriter.write(UserContainer.getUsers());

        System.exit(0);
    }
}
