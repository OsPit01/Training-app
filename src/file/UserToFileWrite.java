package file;

import converter.UserToStringConverter;
import exception.FileWriteException;
import model.User;

import java.io.IOException;
import java.util.List;

public class UserToFileWrite {

    private static final String FILE_NAME = "Information_about_users";
    private final UserToStringConverter userToStringConverter;
    private final java.io.FileWriter writer;
    private final String LINE_WRAPPING = "\n";

    public UserToFileWrite() {
        userToStringConverter = new UserToStringConverter();
        try {
            writer = new java.io.FileWriter(FILE_NAME, true);
        } catch (IOException e) {
            throw new FileWriteException(e);
        }
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
                writer.write(usersString + LINE_WRAPPING);
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