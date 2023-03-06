package converter;

import container.UserContainer;
import model.User;

public class StringToUserConverterSaveContainer {

    public void convert(String line) {
        try {
            String[] words = line.split(" ");
            User user = new User(words[0], words[1], words[2], words[3]);
            UserContainer.save(user);
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }
}
