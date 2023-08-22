package command;

import exception.PrintUserCommandException;
import model.User;
import model.UserRole;
import repository.UserRepository;
import repository.UserSession;

import java.util.ArrayList;
import java.util.List;

public class ShowMeListCommand {
    private final UserRepository userRepository = new UserRepository();

    public String execute() throws PrintUserCommandException {
        UserRole currentRole = UserSession.currentUser.getRole();
        List<User> usersByRole = new ArrayList<>();

        switch (currentRole) {
            case ADMIN -> usersByRole =
                    userRepository.findUsersByRole(List.of(UserRole.ADMIN, UserRole.TRAINEE, UserRole.TRAINER));
            case TRAINER -> usersByRole = userRepository.findUsersByRole(List.of(UserRole.TRAINEE));
            case TRAINEE -> usersByRole = userRepository.findUsersByRole(List.of(UserRole.TRAINER));
        }
        new PrintUsersCommand().execute(usersByRole);
        return "";
    }
}
