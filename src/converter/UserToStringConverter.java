package converter;

import model.User;

import java.util.StringJoiner;

public class UserToStringConverter implements ConverterConstants {

    public String convert(User user) {
        StringJoiner joiner = new StringJoiner(USER_FIELDS_SEPARATOR);
        joiner.add(user.getUsername());
        joiner.add(user.getPassword());
        joiner.add(user.getName());
        joiner.add(user.getSurname());
        return joiner.toString();
    }
}
