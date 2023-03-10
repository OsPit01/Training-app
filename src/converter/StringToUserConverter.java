package converter;

import model.User;

public class StringToUserConverter {
    private static final String USER_FIELDS_SEPARATOR = " ";

    public User convert(String line) {
        if (line != null) {
            String[] words = line.split(USER_FIELDS_SEPARATOR);
            User user = new User(words[0], words[1], words[2], words[3]);
            return user;
        } else {
            return new User("noLogin", "noPassword", "noName", "noSurname");
        }
    }
}
