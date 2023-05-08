package command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import container.UserContainer;
import container.UserSession;
import exception.PrintUserCommandException;
import model.User;
import model.UserRole;

import java.util.ArrayList;
import java.util.List;

public class PrintUsersCommand {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void printFormatUsersToJson(List<User> user) throws PrintUserCommandException {
        String result;
        try {
            result = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new PrintUserCommandException(e);
        }
        System.out.println(result);
    }

    public void print() throws PrintUserCommandException {
        UserRole currentRole = UserSession.currentUser.getRole();
        List<User> usersByRole = new ArrayList<>();

        switch (currentRole) {
            case ADMIN -> usersByRole =
                    UserContainer.findUsersByRole(List.of(UserRole.ADMIN, UserRole.TRAINEE, UserRole.TRAINER));
            case TRAINER -> usersByRole = UserContainer.findUsersByRole(List.of(UserRole.TRAINEE));
            case TRAINEE -> usersByRole = UserContainer.findUsersByRole(List.of(UserRole.TRAINER));
        }
        printFormatUsersToJson(usersByRole);
    }
}
