package converter;

import container.UserSession;
import model.User;
import model.UserRole;

public class StringToUserConverter {

    public User convert(String line) {

        if (line == null || line.isBlank()) {

            throw new IllegalArgumentException(String.format("Illegal argument line = [%s]", line));
        }

        String[] fields = line.split(ConverterConstants.USER_FIELDS_SEPARATOR);
        User user = new User(fields[0], fields[1], fields[2], fields[3], UserSession.currentUser.getRole());
        return user;
    }
}
