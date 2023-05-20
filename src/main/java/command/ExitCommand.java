package command;

import repository.UserRepository;
import file.UserToFileWriter;

public class ExitCommand {
    public void exit() {
        UserToFileWriter userToFileWriter = new UserToFileWriter();
        userToFileWriter.write(UserRepository.getUsers());

        System.exit(0);
    }
}
