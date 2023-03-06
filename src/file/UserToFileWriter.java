package file;

import converter.UserToStringConverter;
import exception.FileWriteException;
import model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserToFileWriter {

    private static final String FILE_NAME = "Information_about_users";
    private final UserToStringConverter userToStringConverter;
    private final FileWriter writer;

    public UserToFileWriter() throws IOException {
        userToStringConverter = new UserToStringConverter();
        writer = new FileWriter(FILE_NAME, true);
    }

    public void write(User user) {
        try {
            String userString = userToStringConverter.convert(user);
            writer.write(userString);
        } catch (IOException e) {
            throw new FileWriteException(e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void write(List<User> users) {
        try {
            for (User user : users) {
                String usersString = userToStringConverter.convert(user);
                writer.write(usersString);
            }
        } catch (IOException e) {
            throw new FileWriteException(e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
               throw new RuntimeException(e);
            }
        }
    }
}