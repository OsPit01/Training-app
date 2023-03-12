package converter;

import model.User;

import java.util.StringJoiner;

public class UserToStringConverter {
    public String USER_FIELDS_SEPARATOR = ConverterConstants.USER_FIELDS_SEPARATOR;

    public String convert(User user) {
        StringJoiner joiner = new StringJoiner(USER_FIELDS_SEPARATOR);
        joiner.add(user.getUsername());
        joiner.add(user.getPassword());
        joiner.add(user.getName());
        joiner.add(user.getSurname());
        return joiner.toString();
    }
}
