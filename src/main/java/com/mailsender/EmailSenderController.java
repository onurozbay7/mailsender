package com.mailsender;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSenderController {

    final private EmailSenderService emailSenderService;

    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/mail")
    public String sendEmail(@RequestBody EmailDto email){
        emailSenderService.sendEmail("ayon1524@gmail.com", email);

        return  "Mail sent successfully";
    }
}
