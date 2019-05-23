package com.example.sendingemail.service;


import com.example.sendingemail.emailDTO.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }


    public void sendEmail(EmailDTO emailDTO) throws MailException

    {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String email = emailDTO.getEmail();
        String productName = emailDTO.getProductName();
        Integer quantity = emailDTO.getQuantity();
        Integer price = emailDTO.getPrice();

        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("saurabhchaurasia179@gmail.com");
        simpleMailMessage.setSubject("techofy");
        simpleMailMessage.setText("the product details are as following:-" + "\n"
                                    + "product name:-  " + productName + "\n"
                                    + "quantity:-  " + quantity + "\n"
                                    + "Total price:-  " + price +"\n"
                                    +"happy to serve you!!!");

       javaMailSender.send(simpleMailMessage);

    }
}
