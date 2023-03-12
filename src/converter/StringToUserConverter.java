package converter;

import model.User;

public class StringToUserConverter {
    public String USER_FIELDS_SEPARATOR = ConverterConstants.USER_FIELDS_SEPARATOR;

    public User convert(String line) {

        if (line == null) { // todo: check blank strings
            throw new IllegalArgumentException("string = null");
        }
        if (line.isBlank()) {
            return null;
        }
        if (line.isEmpty()) {
            return null;
        } else {
            String[] words = line.split(USER_FIELDS_SEPARATOR);
            User user = new User(words[0], words[1], words[2], words[3]);
            return user;
        }
    }
}

