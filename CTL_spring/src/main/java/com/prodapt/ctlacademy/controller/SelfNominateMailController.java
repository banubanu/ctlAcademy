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

public class SelfNominateMailController {
	
  @Autowired

    private JavaMailSender sender;
 
    

                @PostMapping("/sendMail")
    public String sendMailStartMethod(@RequestBody ElNomination elNomination)  throws MessagingException{
                SimpleMailMessage message =new SimpleMailMessage();
                
                message.setFrom("vaishnavi.s@prodapt.com");
                message.setTo(elNomination.getElNomEmpMail(),"vaishnavi.s@prodapt.com");
                message.setSubject("Approval Request");
//                message.setCc(elNomination.getElRmEmail());
                message.setText("Hi Admin,\r\n "+elNomination.getElNomEmpName()+" has requested your approval to take "+elNomination.getElNomCourse()+" course");   
                sender.send(message);     
                return "Mail Sent Success!";
}
                
                
                
                

                @PostMapping("/approvalMail")
    public String sendApprovalMailStartMethod(@RequestBody ElNomination elNomination)  throws MessagingException{
                SimpleMailMessage message =new SimpleMailMessage();

                message.setTo(elNomination.getElNomEmpMail(),"vaishnavi.s@prodapt.com");
                message.setSubject("Approval");
                message.setFrom("vaishnavi.s@prodapt.com");
//                message.setCc(elNomination.getElRmEmail());
                message.setText("Hi "+elNomination.getElNomEmpName()+" , \r\n Admin has approved your request for taking "+elNomination.getElNomCourse()+" course");   
                sender.send(message);     
                return "Mail Sent Success!";
}
    }





            
    
