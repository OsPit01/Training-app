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
    public ObjectMapper objectMapper = new ObjectMapper();

    public void printFormatUsersToJson(List<User> user) throws JsonProcessingException {
        String result = objectMapper.writeValueAsString(user);
        System.out.println(result);
    }

    public void printUsersRole() {
        String role = UserSession.currentUser.getRole();
        UserRole userRoleAdmin = UserRole.admin;
        UserRole userRoleTrainer = UserRole.trainer;

        if (role.equals(userRoleAdmin.toString())) {
            List<User> usersByRole = UserContainer.findUsersByRole(List.of("admin", "trainer", "trainee"));
            try {
                printFormatUsersToJson(usersByRole);
            } catch (JsonProcessingException e) {
                throw new JsonException(e);
            }
        }

        if (role.equals(userRoleTrainer.toString())) {
            List<User> userByRole = UserContainer.findUsersByRole(List.of("trainee"));
            try {
                printFormatUsersToJson(userByRole);
            } catch (JsonProcessingException e) {
                throw new JsonException(e);
            }
        } else {
            List<User> userByRole = UserContainer.findUsersByRole(List.of("trainer"));
            try {
                printFormatUsersToJson(userByRole);
            } catch (JsonProcessingException e) {
                throw new JsonException(e);
            }
        }
    }
}
