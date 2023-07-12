package file;

import converter.UserToStringConverter;
import exception.FileWriterException;
import model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserToFileWriter {

    private static final String FILE_NAME = "Information_about_users";

    private static final String LINE_SEPARATOR = "\n";
    private final UserToStringConverter userToStringConverter;
    private final FileWriter writer;

    public UserToFileWriter() {
        userToStringConverter = new UserToStringConverter();
        try {
            writer = new FileWriter(FILE_NAME);
        } catch (IOException e) {
            throw new FileWriterException("File not found for write");
        }
    }

    public void write(User user) {
        try {
            String userString = userToStringConverter.convert(user);
            writer.write(userString);
        } catch (IOException e) {
            throw new FileWriterException(e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new FileWriterException(e + "Exception in UserToFileWriter --> write");
            }
        }
    }

    public void write(List<User> users) {
        try {
            for (User user : users) {
                String userString = userToStringConverter.convert(user);
                writer.write(userString + LINE_SEPARATOR);
            }
        } catch (IOException e) {
            throw new FileWriterException(e + "Exception in UserToFileWriter --> write");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new FileWriterException(e);
            }
        }
    }
}
