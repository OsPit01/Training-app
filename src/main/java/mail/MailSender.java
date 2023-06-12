package mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {

    private static final String FROM = "lovejudo96@mail.ru";
    private static final String PASSWORD = "H0MgB6jG0ehEqpLZjVCS";

    private static final Properties properties = new Properties();

    public MailSender() {
        properties.put("mail.smtp.host", "smtp.mail.ru");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
    }

    public Session getSession() {
        Session session = Session.getInstance(
                properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(FROM, PASSWORD);
                    }
                }
        );
        session.setDebug(true);
        return session;
    }

    public void sendEmail(String email, String password) throws MessagingException {
        Session session = getSession();
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(FROM));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("this is text");
        message.setText("Generated password::" + " " + password);
        Transport.send(message);
        System.out.println("Email Sent successfully....");
    }
}
