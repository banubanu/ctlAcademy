
package com.prodapt.ctlacademy.controller;


import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.ctlacademy.model.ElCourseComp;
import com.prodapt.ctlacademy.model.ElCourseContent;
import com.prodapt.ctlacademy.repository.ElCourseCompRepository;
import com.prodapt.ctlacademy.repository.ElCourseContentRepository;
import com.prodapt.ctlacademy.service.ElCourseCompService;
import com.prodapt.ctlacademy.service.ElCourseService;


@RestController
@CrossOrigin("*")
//@RequestMapping("/getCompDetails")
public class ElCourseCompController {
	
  @Autowired

    private JavaMailSender sender;
  
  @Autowired
  ElCourseCompService elCourseCompService;
	
	@Autowired
	ElCourseCompRepository elCourseCompRepository;
 
//  @RequestMapping(value = "/get-compStatus", method = RequestMethod.GET)
//	public List<ElCourseComp> getUsers() {
//	       return this.elCourseCompService.getAll();
//	}

//                @PostMapping("/courseCompMail")
//    public String sendMailStartMethod(@RequestBody ElContent elContent)  throws MessagingException{
//                SimpleMailMessage message =new SimpleMailMessage();
//
//                message.setTo("vaishnavi.s@prodapt.com");
//                message.setSubject("Course Completion");
//                message.setFrom("vaishnavi.s@prodapt.com");
//                message.setText("Hi, you have successfully completed the course /r/n Thanks, /r/n CTLAcademy");
//                sender.send(message);     
//                return "Mail Sent Success!";
}


