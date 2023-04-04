package command;

import com.fasterxml.jackson.core.JsonProcessingException;
import container.UserContainer;

public class PrintUsersCommand {
    public void printUsers() throws JsonProcessingException {
        System.out.println(UserContainer.getUsers());
    }
}
