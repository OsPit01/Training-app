package command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exception.PrintUserCommandException;
import model.User;

import java.util.List;

public class PrintUsersCommand {
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
}
