package model;

public class UserValidator {

    public boolean isValid(User user) {
        if (user == null) {
            return false;
        }
        return user.getUsername() != null && user.getPassword() != null && user.getName() != null && user.getSurname() != null;
    }
}
