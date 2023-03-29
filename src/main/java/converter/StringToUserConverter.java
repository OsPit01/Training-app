package converter;

import model.User;

public class StringToUserConverter {

    public User convert(String line) {


        if (line == null || line.isBlank()) {
            throw new IllegalArgumentException("line = null");
        }

        String[] fields = line.split(ConverterConstants.USER_FIELDS_SEPARATOR);
        User user = new User(fields[0], fields[1], fields[2], fields[3]);
        return user;
    }
}
