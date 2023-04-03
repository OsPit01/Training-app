package command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import container.UserContainer;

public class JsonCommand {
        public ObjectMapper objectMapper = new ObjectMapper();

        public void convertToJasonFormat() throws JsonProcessingException {

            String result = objectMapper.writeValueAsString(UserContainer.getUsers());
            System.out.println(result);
            System.out.println("-----------------------Json----------------------------------------------------------");
        }
        public void   printUserToJasonFormat(String role) throws JsonProcessingException {
            String result = objectMapper.writeValueAsString(role);
            System.out.println(result);
        }

}
