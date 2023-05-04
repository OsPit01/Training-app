package command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import container.UserContainer;
import container.UserSession;
import exception.JsonException;
import model.User;
import model.UserRole;

import java.util.List;

public class PrintUsersCommand {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void printFormatUsersToJson(List<User> user) {
        String result;
        try {
            result = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new JsonException(e);
        }
        System.out.println(result);
    }

    public void print() {
        UserRole enumRole = UserSession.currentUser.getRole();
        List<User> usersByRole;

        switch (enumRole) {
            case ADMIN -> {
                usersByRole = UserContainer.findUsersByRole(List.of(UserRole.ADMIN, UserRole.TRAINEE, UserRole.TRAINER));
                printFormatUsersToJson(usersByRole);
            }
            case TRAINER -> {
                usersByRole = UserContainer.findUsersByRole(List.of(UserRole.TRAINEE));
                printFormatUsersToJson(usersByRole);
            }
            case TRAINEE -> {
                usersByRole = UserContainer.findUsersByRole(List.of(UserRole.TRAINER));
                printFormatUsersToJson(usersByRole);
            }
        }
    }
}
