package com.mailsender;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class EmailSenderController {

    final private EmailSenderService emailSenderService;

    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @CrossOrigin
    @PostMapping("/mail")
    public String sendEmail(@RequestBody EmailDto email){
        emailSenderService.sendEmail("info@greatbearfitness.co.uk", email);

        return  "Mail sent successfully";
    }
}
