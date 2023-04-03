package command;

import com.fasterxml.jackson.core.JsonProcessingException;
import container.UserContainer;

public class PrintUsersCommand {
    public void printUsers() throws JsonProcessingException {
        JsonCommand jsonCommand = new JsonCommand();
        jsonCommand.convertToJasonFormat();
        System.out.println(UserContainer.getUsers());
    }
}
