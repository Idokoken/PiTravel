package ndgroups.PiTravel.emailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendVerificationEmail(String to, String token) {

        try {
            // Use localhost link for development/testing
            // String link = "http://localhost:8000/api/auth/verify?token=" + token;
            String link = "https://pitravel.onrender.com/api/auth/verify?token=" + token;

            String subject = "Verify your email";
            String body = "Thank you for registering.\n\n"
                    + "Please click the link below to verify your email:\n"
                    + link + "\n\n"
                    + "This link will expire in 24 hours.";

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);  // Your own Gmail for testing
            message.setSubject(subject);
            message.setText(body);

            // Use your development no-reply email
            message.setFrom("idokobryan01@gmail.com");

            mailSender.send(message);
            System.out.println("Verification email sent to: " + to);

        }
        catch (Exception e) {
            System.err.println("❌ Failed to send email to " + to + ". Error: " + e.getMessage());
        }
    }

    //    Send Notification Email on Account Creation
    @Async
    public void sendAccountCreationNotificationEmail(String toEmail, String username){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(toEmail);
        message.setSubject("Welcome to PiTravel");
        message.setText(
                "Hello " + username + ",\n\n" +
                        "Your account has been created successfully.\n\n" +
                        "Easily Book your local and international flight \n\n" +
                        "We are here to move you round the world!"
        );

        mailSender.send(message);
        System.out.println("Welcome email sent to: " + toEmail);

    }
}
