package converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.io.IOException;

public class JsonToUserConverter {

    private final ObjectMapper mapper = new ObjectMapper();

    public User convert(String line) throws IOException {

        User user = mapper.readValue(line, User.class);

        return user;
    }
}
