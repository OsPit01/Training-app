package command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import container.UserContainer;
import model.User;

public class JsonCommand {
    public ObjectMapper objectMapper = new ObjectMapper();

    public void printAllUsers() throws JsonProcessingException {
        String result = objectMapper.writeValueAsString(UserContainer.getUsers());
        System.out.println(result);
        System.out.println("-----------------------Json----------------------------------------------------------");
    }

    public void printTrainers() throws JsonProcessingException {
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
}
