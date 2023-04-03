package converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import container.UserContainer;

public class UserToJsonFormatConverter {


    public class UsersToJsonFormatConverter {

        public void main(String[] args) throws JsonProcessingException {
            UsersToJsonFormatConverter usersToJsonFormatConverter = new UsersToJsonFormatConverter();
            usersToJsonFormatConverter.convertToJasonFormat();
        }
        public ObjectMapper objectMapper = new ObjectMapper();

        public void convertToJasonFormat() throws JsonProcessingException {

            String result = objectMapper.writeValueAsString(UserContainer.getUsers());
            System.out.println(result);
        }
    }
}
