package command;

import mail.MailSender;
import mail.PasswordGenerator;
import model.User;
import service.UserService;

import javax.mail.MessagingException;

public class RegisterCommand {
    private final UserService userService = new UserService();
    private final PasswordGenerator passwordGenerator = new PasswordGenerator();

    public void execute(User user) throws MessagingException {
        if (userService.isUserExists(user.getUsername())) {
            System.out.println("such a user exist already");
        } else {
            String generatedPassword = passwordGenerator.getRandomPassword();
            user.setPassword(generatedPassword);
            userService.saveUser(user);

            MailSender mail = new MailSender();
            mail.sendEmail(user.getEmail(), user.getPassword());
            System.out.println("Registration was successful");
        }
    }
}
