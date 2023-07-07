package command;

import file.UserToFileWriter;
import model.User;
import repository.UserRepository;

import java.util.List;

public class ExitCommand {

    public void execute() {
        UserToFileWriter userToFileWriter = new UserToFileWriter();
        List<User> listUsers = new UserRepository().getUsers();
        userToFileWriter.write(listUsers);

        System.exit(0);
    }
}
