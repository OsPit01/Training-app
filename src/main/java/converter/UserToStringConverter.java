package converter;

import model.User;

import java.util.StringJoiner;

public class UserToStringConverter {

    public String convert(User user) {
        if (user == null) {
            throw new IllegalArgumentException("String = null");
        }
        if(user.getUsername() == null || user.getPassword() == null || user.getName() == null || user.getUsername() == null){
            throw new IllegalArgumentException("field = null");

        }
        StringJoiner joiner = new StringJoiner(ConverterConstants.USER_FIELDS_SEPARATOR);
        joiner.add(user.getUsername());
        joiner.add(user.getPassword());
        joiner.add(user.getName());
        joiner.add(user.getSurname());
        return joiner.toString();
    }
}
