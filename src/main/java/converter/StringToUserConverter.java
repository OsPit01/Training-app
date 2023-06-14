package converter;

import model.User;
import model.UserRole;
import model.UserStatus;

public class StringToUserConverter {

    public User convert(String line) {

        if (line == null || line.isBlank()) {

            throw new IllegalArgumentException(String.format("Illegal argument line = [%s]", line));
        }

        String[] fields = line.split(ConverterConstants.USER_FIELDS_SEPARATOR);
        UserRole role = UserRole.valueOf(fields[4].toUpperCase());
        UserStatus status = UserStatus.valueOf(fields[5].toUpperCase());
        User user = new User(fields[0], fields[1], fields[2], fields[3], role, status, fields[6], fields[7]);

        return user;
    }
}
