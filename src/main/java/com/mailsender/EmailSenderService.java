package com.mailsender;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    final private JavaMailSender javaMailSender;

    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String sendEmail(String toEmail, EmailDto emailDto){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("approvalsender@gmail.com");
        message.setTo(toEmail);
        message.setSubject("You have an email from your website");
        message.setText(
                "Fullname: " + emailDto.getFullname() + "\n" +
                        "Email: " + emailDto.getEmail() + "\n" +
                        "Phone: " + emailDto.getPhone() + "\n" +
                        "Adress: " + emailDto.getAdress() + "\n \n \n" +
                        "Subject: " + emailDto.getSubject() + "\n" +
                        "Message: " + emailDto.getMessage()
        );

        javaMailSender.send(message);

        return "Mail sent successfully";
    }
}
