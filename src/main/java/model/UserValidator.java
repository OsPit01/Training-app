package model;

public class UserValidator {

    public boolean isValid(User user) {
        if (user == null) {
            return false;
        }
        if (user.getUsername() != null  &&
                user.getName() != null && user.getSurname() != null &&
        user.getEmail() != null) {
            return true;
        }
        return false;
    }
}
