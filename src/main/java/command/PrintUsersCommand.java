package command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.util.List;

public class PrintUsersCommand {
    public ObjectMapper objectMapper = new ObjectMapper();

    public void printUsers(List<User> user) throws JsonProcessingException {
        String result = objectMapper.writeValueAsString(user);
        System.out.println(result);
    }
}
