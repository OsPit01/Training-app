package command;


import repository.UserSession;

public class ChangeDataCommand {
    public void changePassword(String inputPassword) {
        UserSession.currentUser.setPassword(inputPassword);
    }

    public void changeInputSurname(String inputSurname) {
        UserSession.currentUser.setSurname(inputSurname);
    }

    public void changeUsername(String inputUsername) {
        UserSession.currentUser.setUsername(inputUsername);
    }

    public void changeRole(String inputRole) {
        UserSession.currentUser.setSurname(inputRole);
    }

    public void changeStatus(String inputStatus) {
        UserSession.currentUser.setSurname(inputStatus);
    }

    public void changeName(String inputName) {
        UserSession.currentUser.setSurname(inputName);
    }
}
