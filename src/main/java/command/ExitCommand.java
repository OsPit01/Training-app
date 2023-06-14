package command;

import file.UserToFileWriter;
import model.User;
import repository.UserRepository;

import java.util.List;

public class ExitCommand {
    public void execute() {
        UserToFileWriter userToFileWriter = new UserToFileWriter();
        List<User> userRepository = new UserRepository().getUsers();
        userToFileWriter.write(userRepository);

        System.exit(0);
    }
}
