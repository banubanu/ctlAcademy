package com.prodapt.ctlacademy.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.ctlacademy.model.ElNomination;

@RestController
@CrossOrigin("*")

public class MailController {
	
  @Autowired

    private JavaMailSender sender;
 
    

                @PostMapping("/sendMailStartMethod")
    public String sendMailStartMethod(@RequestBody ElNomination elNomination)  throws MessagingException{
                SimpleMailMessage message =new SimpleMailMessage();
//        MimeMessage message = sender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);

                				message.setTo(elNomination.getElNomEmpMail(),"vaishnavi.s@prodapt.com");
                                message.setSubject("Approval Request");
                                message.setFrom("vaishnavi.s@prodapt.com");
//                                message.setCc(elNomination.getElRmEmail());
                                message.setText("Hi "+elNomination.getElNomEmpName()+",\r\n admin has recommended you to take "+elNomination.getElNomCourse()+" course");   
                                sender.send(message);     
                                return "Mail Sent Success!";
    }
               
                
                
            
}

            
    