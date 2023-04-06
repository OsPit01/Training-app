package command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import container.UserContainer;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class PrintUsersCommand {
    public ObjectMapper objectMapper = new ObjectMapper();

    public void printTrainer() throws JsonProcessingException {
        List<User> usersList = new ArrayList<>();
        int size = UserContainer.getUsers().size();
        for (int i = 0; i < size; i++) {
            if (UserContainer.getUsers().get(i).getRole().equals("trainer")) {
                usersList.add(UserContainer.getUsers().get(i));
            }
        }
        String result = objectMapper.writeValueAsString(usersList);
        System.out.println(result);
    }

    public void printTrainee() throws JsonProcessingException {
        List<User> usersList = new ArrayList<>();
        int size = UserContainer.getUsers().size();
        for (int i = 0; i < size; i++) {
            if (UserContainer.getUsers().get(i).getRole().equals("trainee")) {
                usersList.add(UserContainer.getUsers().get(i));
            }
        }
        String result = objectMapper.writeValueAsString(usersList);
        System.out.println(result);
    }

    public void printAllUsers() throws JsonProcessingException {
        List<User> usersList = UserContainer.getUsers();
        String result = objectMapper.writeValueAsString(usersList);
        System.out.println(result);
    }
}
