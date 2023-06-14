package ui;

import model.User;
import repository.UserRepository;

public class UserId {
    public void setId(User user) {
        UserRepository userRepository = new UserRepository();
        int size = userRepository.getUsers().size();
        String id = String.valueOf(size);
        user.setId(id);

    }
}
