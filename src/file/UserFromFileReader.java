package file;

import converter.StringToUserConverter;
import exception.FileReaderException;
import model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserFromFileReader {
    private static final String FILE_NAME = "Information_about_users";
    private final File file;
    private final Scanner scanner;
    private final StringToUserConverter converter = new StringToUserConverter();

    public UserFromFileReader() {
        file = new File(FILE_NAME);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new FileReaderException("File not found for read");
        }
    }

    public List<User> read() {
        List<User> users = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            User user = converter.convert(line);
            users.add(user);
        }
        return users;
    }
}
