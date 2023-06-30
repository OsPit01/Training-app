package command;


import repository.UserSession;

public class ChangeDataCommand {
    public void changeCurrentUser(String username,String password,String surname) {

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
