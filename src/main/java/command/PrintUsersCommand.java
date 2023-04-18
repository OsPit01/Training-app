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
    public final ObjectMapper objectMapper = new ObjectMapper();

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

        if (role.equalsIgnoreCase(userRoleAdmin.toString())) {
            List<User> usersByRole = UserContainer.findUsersByRole(List.of("admin", "trainer", "trainee"));
            printFormatUsersToJson(usersByRole);
        }

        if (role.equalsIgnoreCase(userRoleTrainer.toString())) {
            List<User> userByRole = UserContainer.findUsersByRole(List.of("trainee"));
            printFormatUsersToJson(userByRole);
        }
        if (role.equalsIgnoreCase(userRoleTrainee.toString())) {
            List<User> userByRole = UserContainer.findUsersByRole(List.of("trainer"));
            printFormatUsersToJson(userByRole);
        }
    }
}
