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
        String result = null;
        try {
            result = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new JsonException(e);
        }
        System.out.println(result);
    }

    public void print() {
        String role = UserSession.currentUser.getRole();
        UserRole userRoleAdmin = UserRole.ADMIN;
        UserRole userRoleTrainer = UserRole.TRAINER;
        UserRole userRoleTrainee = UserRole.TRAINEE;

        if (role.equals(userRoleAdmin)) {
            List<User> usersByRole = UserContainer.findUsersByRole(List.of(userRoleAdmin.toString()));
            printFormatUsersToJson(usersByRole);
        }

        if (role.equals(userRoleTrainer)) {
            List<User> userByRole = UserContainer.findUsersByRole(List.of("trainee"));
            printFormatUsersToJson(userByRole);
        }
        if (role.equals(userRoleTrainee)) {
            List<User> userByRole = UserContainer.findUsersByRole(List.of("trainer"));
            printFormatUsersToJson(userByRole);
        }
    }
}
