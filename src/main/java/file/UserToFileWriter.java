package file;

import com.fasterxml.jackson.databind.ObjectMapper;
import converter.UserToStringConverter;
import exception.FileWriterException;
import model.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserToFileWriter {

    private static final String FILE_NAME = "Information_about_users";

    private static final String FILE_JSON = "JsonFile";
    private static final String LINE_SEPARATOR = "\n";
    private final UserToStringConverter userToStringConverter;
    private final FileWriter writer;
    private final ObjectMapper objectMapper = new ObjectMapper();

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

    public void writeUserInJsonFormatToFile(User user) throws IOException {
        System.out.println("process write to JsonFile ");
        System.out.println(objectMapper.writeValueAsString(user));
        objectMapper.writeValue(new File(FILE_JSON), user);
    }
}
