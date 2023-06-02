package command;

import file.UserToFileWriter;
import repository.UserRepository;

public class ExitCommand {
    public void execute() {
        UserToFileWriter userToFileWriter = new UserToFileWriter();
        userToFileWriter.write(UserRepository.getUsers());

        System.exit(0);
    }
}
