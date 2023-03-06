package command;

import container.UserContainer;
import file.UserToFileWriter;

import java.io.IOException;

public class ExitCommand {


    public void exit()  {
        try {
            new UserToFileWriter().write(UserContainer.getUsers());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }
}
