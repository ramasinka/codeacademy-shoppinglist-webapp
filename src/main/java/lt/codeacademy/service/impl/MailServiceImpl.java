package lt.codeacademy.service.impl;

import lt.codeacademy.model.ShareSummary;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailServiceImpl {

    public void sendMail(String listName, ShareSummary shareSummary, String recipientEmail) {
        final String username = "codeacademystudent11@gmail.com";
        final String password = "codeacademy";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Codeacademy"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipientEmail));
            message.setSubject("Share shopping list");
            message.setText("Hello. You share shopping list with name: " + listName +
                    "\n\n Link to confirmation: localhost:8080/confirmationShare/" + shareSummary.getId());

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
