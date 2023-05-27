package com.mailsender;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class EmailSenderService {

    final private JavaMailSender javaMailSender;

    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String sendEmail(String toEmail, EmailDto emailDto){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("approvalsender@gmail.com");
        message.setTo(toEmail);
        message.setSubject("You have an email from " + emailDto.getFullname() + " - " + dateFormat.format(date));
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
