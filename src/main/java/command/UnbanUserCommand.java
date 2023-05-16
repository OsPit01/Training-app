package command;

import container.UserContainer;
import file.UserToFileWriter;
import model.User;
import model.UserStatus;

public class UnbanUserCommand {

    public void unban(String userName) {
        try {
            User user = UserContainer.findUserByUsername(userName);
            assert user != null;
            user.setStatus(UserStatus.ACTIVE);
            UserToFileWriter userToFileWriter = new UserToFileWriter();
            userToFileWriter.write(UserContainer.getUsers());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
