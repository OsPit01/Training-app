package command;


import repository.UserSession;

public class CommandChangePassword {

    public void execute(String inputPassword) {
        UserSession.currentUser.setPassword(inputPassword);
    }
}
