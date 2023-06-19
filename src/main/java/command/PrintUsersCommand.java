package command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exception.PrintUserCommandException;
import model.User;
import model.UserRole;
import repository.UserRepository;
import repository.UserSession;

import java.util.ArrayList;
import java.util.List;

public class PrintUsersCommand {
    public UserRepository userRepository = new UserRepository();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void execute(List<User> user) throws PrintUserCommandException {
        String result;
        try {
            result = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new PrintUserCommandException(e);
        }
        System.out.println(result);
    }

    public void execute() throws PrintUserCommandException {
        UserRole currentRole = UserSession.currentUser.getRole();
        List<User> usersByRole = new ArrayList<>();

        switch (currentRole) {
            case ADMIN -> usersByRole =
                    userRepository.findUsersByRole(List.of(UserRole.ADMIN, UserRole.TRAINEE, UserRole.TRAINER));
            case TRAINER -> usersByRole = userRepository.findUsersByRole(List.of(UserRole.TRAINEE));
            case TRAINEE -> usersByRole = userRepository.findUsersByRole(List.of(UserRole.TRAINER));
        }
        execute(usersByRole);
    }
}
