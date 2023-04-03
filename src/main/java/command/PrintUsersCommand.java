package command;

import com.fasterxml.jackson.core.JsonProcessingException;
import converter.UserToJsonFormatConverter;

public class PrintUsersCommand {
    public void printUsers() throws JsonProcessingException {
        //System.out.println(UserContainer.getUsers());
        UserToJsonFormatConverter userToJsonFormatConverter = new UserToJsonFormatConverter();
        userToJsonFormatConverter.convertToJasonFormat();
    }
}
