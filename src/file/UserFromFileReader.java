package file;

import converter.StringToUserConverter;
import model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserFromFileReader {

    File file;
    private final Scanner scanner;

    public UserFromFileReader() {
        file = new File("Information_about_users");
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public List<User> read() {
        List<User> user = new ArrayList<>();
        StringToUserConverter converter = new StringToUserConverter();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            user.add(converter.convert(line));
        }
        return user;
    }
}
