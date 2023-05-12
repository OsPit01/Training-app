package container;

import model.User;
import model.UserRole;

public class UserSession {
    public static User currentUser;
    public void clearCurrentUser() {
        currentUser = new User(" ", "", "", "", UserRole.GHOST, "");
    }
}
