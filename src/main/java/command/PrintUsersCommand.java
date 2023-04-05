package command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import container.UserContainer;
import model.User;

public class PrintUsersCommand {
    public ObjectMapper objectMapper = new ObjectMapper();

    public void printUsers() throws JsonProcessingException {
        System.out.println(UserContainer.getUsers());
    }

    public void printTrainer() throws JsonProcessingException {
        int size = UserContainer.getUsers().size();
        for (int i = 0; i < size; i++) {
            User user = UserContainer.getUsers().get(i);
            if (user.getRole().equals("trainer")) {
                String result = objectMapper.writeValueAsString(user);
                System.out.println(result);
            }
        }
    }

    public void printTrainee() throws JsonProcessingException {

        int size = UserContainer.getUsers().size();
        for (int i = 0; i < size; i++) {
            User user = UserContainer.getUsers().get(i);
            if (user.getRole().equals("trainee")) {
                String result = objectMapper.writeValueAsString(user);
                System.out.println(result);
            }
        }
    }

    public void printAllUsers() throws JsonProcessingException {
        String result = objectMapper.writeValueAsString(UserContainer.getUsers());
        System.out.println(result);

    }
}
