package file;

import converter.StringToUserConverter;
import exception.FileReaderException;
import model.User;
import model.UserRole;
import model.UserStatus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserFromFileReader {
    private static final String FILE_NAME = "Information_about_users";
    private final Scanner scanner;
    private final StringToUserConverter converter;

    public UserFromFileReader() {

        converter = new StringToUserConverter();
        try {
            scanner = new Scanner(new File(FILE_NAME));
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

    public static void main(String[] args) {
        System.out.println("SECOND MAIN");
        ArrayList<User> users = new ArrayList<>();
        UserFromFileReader userFromFileReader = new UserFromFileReader();

        System.out.println("READING FROM FILE");
        List<User> receiveUsers = userFromFileReader.read();
        System.out.println(receiveUsers);
        User user3 = new User("dad3", "dodik3", "dacik4", UserRole.TRAINEE,
                UserStatus.ACTIVE, "lovejudo96@mail.ru");

        System.out.println("DOING WRITE IN FILE");

        users.add(receiveUsers.get(0));
        users.add(receiveUsers.get(1));
        users.add(user3);
        UserToFileWriter userToFileWriter = new UserToFileWriter();
        userToFileWriter.write(users);
    }
}
