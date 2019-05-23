package com.example.sendingemail.controller;


import com.example.sendingemail.emailDTO.EmailDTO;
import com.example.sendingemail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;


    @RequestMapping("/sendMail")
    public String sendemail(@RequestBody EmailDTO emailDTO){

        try{
            emailService.sendEmail(emailDTO);
        }catch (MailException e){
            e.printStackTrace();
        }

        return "successfully sent";

    }


}
