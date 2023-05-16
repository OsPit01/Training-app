package command;

import container.UserContainer;
import file.UserToFileWriter;
import model.User;
import model.UserRole;
import model.UserStatus;

public class BanUsersCommand {
    public void ban(String userName) {
        try {
            User user = UserContainer.findUserByUsername(userName);

            if (user != null) {
                if (user.getRole().equals(UserRole.ADMIN)) {
                    System.out.println("this is Admin");

                } else {
                    user.setStatus(UserStatus.BAN);
                    UserToFileWriter userToFileWriter = new UserToFileWriter();
                    userToFileWriter.write(UserContainer.getUsers());
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
