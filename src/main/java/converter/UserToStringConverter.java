package converter;

import model.User;
import model.UserValidator;

import java.util.StringJoiner;

public class UserToStringConverter {
    private final UserValidator validator = new UserValidator();

    public String convert(User user) {
        if (!(validator.isValid(user))) {  //todo move to another laye
            throw new IllegalArgumentException(String.format("invalid user = [%s]", user));
        }

        StringJoiner joiner = new StringJoiner(ConverterConstants.USER_FIELDS_SEPARATOR);
        joiner.add(user.getUsername());
        joiner.add(user.getPassword());
        joiner.add(user.getName());
        joiner.add(user.getSurname());
        joiner.add(user.getRole().toString());
        joiner.add(user.getStatus().toString());
        joiner.add(user.getEmail());
        joiner.add(String.valueOf(user.getId()));
        return joiner.toString();
    }
}
