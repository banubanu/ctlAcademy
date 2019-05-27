package com.prodapt.ctlacademy.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prodapt.ctlacademy.dto.CourseDTO;
import com.prodapt.ctlacademy.model.ElCourseContent;
import com.prodapt.ctlacademy.repository.ElCourseContentRepository;
import com.prodapt.ctlacademy.service.ElCourseService;
import com.prodapt.ctlacademy.util.ApplicationUtil;
import com.prodapt.ctlacademy.util.PDFUtil;

@RestController
@CrossOrigin("*")

@RequestMapping("/addCourse")
public class ElCourseContentController {
	
	@Autowired
	ElCourseService elCourseService;
	
	 @Autowired

	    private JavaMailSender sender;
	  
	
	@Autowired
	ElCourseContentRepository elCourseContentRepository;
	
	@Value("${application.base.media}")
	private String storagePath;
	
	public ElCourseContentController(ElCourseService elCourseService ) {
		this.elCourseService=elCourseService;
	}
	
//	@RequestMapping(value="/save", method= RequestMethod.POST)
//	
//	public ElCourseContent save(@RequestBody ElCourseContent elcc)
//	{
//		
//		return elCourseContentService.save(elcc);
//	}
//	Should not call repository method directly in controller
//	@GetMapping("get")
//	public List<ElCourseContent> getAll() {
//		 
//		return this.elCourseContentRepository.findAll();
//
//	}
//	
	
	@PostMapping("save")
	public ElCourseContent save(@RequestBody ElCourseContent elcc) {
		 
		return this.elCourseContentRepository.save(elcc);

	}
	
	@RequestMapping(value="/uploads",method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
		File convertFile= new File("/home/ubuntu/Desktop/images/uploads/"+file.getOriginalFilename());
		  System.out.println(convertFile);
		convertFile.createNewFile();
		FileOutputStream fout=new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		 System.out.println(file);
		fout.close();

		return new ResponseEntity<>("File uploaded Successfully",HttpStatus.OK) ;
	} 

	@RequestMapping(value="/uploads1",method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile1(@RequestParam("file1") MultipartFile file1 ,@RequestParam("file") MultipartFile file, @RequestPart(required = false) Map<String, String> json, CourseDTO course) throws IOException{
		
//		byte[] bytes = file1.getBytes();
//		Path path = Paths.get(storagePath  +file1.getOriginalFilename());
//		path.toAbsolutePath();
//		Path pathDir = Paths.get(storagePath  +"\\SUB\\IMG\\"+file1.getOriginalFilename());
		try {
			File files = new File(this.storagePath + course.getDomainName()+ File.separator + course.getCourseName() + File.separator + ApplicationUtil.MEDIA_FOLDER.Content.toString());
	        if (!files.exists()) 
	        {
	            if (files.mkdirs()) 
	                      {
	                       System.out.println("Multiple directories are created!");
	                       
	                      }
	            else    {
	                    System.out.println("Failed to create multiple directories!");      
	                    }
	    		File convertFile= new File(this.storagePath + course.getDomainName()+ File.separator + course.getCourseName()+File.separator + ApplicationUtil.MEDIA_FOLDER.Content.toString() + File.separator+file1.getOriginalFilename());
	    		convertFile.createNewFile();
	    		FileOutputStream fout=new FileOutputStream(convertFile);
	    		fout.write(file1.getBytes());
	    		fout.close();
	    		
	    		// Ek aur multipart request param lagao method definition me, aur use store karo fs me save karo us image ko
	    		// Save karne ke baad jo path return hoga, use 
	    		
	    		File convertFile1= new File(this.storagePath + course.getDomainName()+ File.separator + course.getCourseName()+File.separator+file.getOriginalFilename());
	  		  System.out.println(convertFile1);
	  		  
	  		convertFile1.createNewFile();
	  		FileOutputStream fout1=new FileOutputStream(convertFile1);
	  		fout1.write(file.getBytes());
	  		fout1.close();
	        }
	        else {
//	        	Files.write(pathDir, bytes);
        		
	        }
	        String pages = PDFUtil.pdfToImages(files.getAbsolutePath() + File.separator+file1.getOriginalFilename(), this.storagePath, course.getDomainName()+ File.separator + course.getCourseName() + File.separator + ApplicationUtil.MEDIA_FOLDER.Content.toString() + File.separator);
	        ElCourseContent content = new ElCourseContent();
	        int i = 0;
	        	content.setElCourseImage(course.getDomainName()+ File.separator + course.getCourseName()+File.separator+file.getOriginalFilename()); // yaha laga do
	        	content.setElContentType(ApplicationUtil.CONTENT_TYPE.S.toString());
	        	content.setElDomainName(course.getDomainName());
	        	content.setElCourseName( course.getCourseName());
	        	content.setElCourseDesc(course.getCourseDesc());
	        	content.setElTrainer(course.getTrainer());
	        	content.setElCourseContent(pages);
	        	content.setElSubmitedDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
	        	elCourseService.save(content);
	        	i++;
		
		}
		catch (NoSuchFileException  e) {
			e.printStackTrace();
		}
		  
		return new ResponseEntity<>("File converted Successfully",HttpStatus.OK) ;
	}
	
	
	
	
	
	
	
//	for fetching details
	
	@RequestMapping(value = "/get-details", method = RequestMethod.GET)
	public List<ElCourseContent> getUsers() {
	       return this.elCourseService.getAll();
	}
	
	
	
	 @PostMapping("/courseCompMail")
	    public String sendMailStartMethod(@RequestBody ElCourseContent elCourseContent)  throws MessagingException{
	                SimpleMailMessage message =new SimpleMailMessage();

	                message.setTo("vaishnavi.s@prodapt.com");
	                message.setSubject("Course Completion");
	                message.setFrom("vaishnavi.s@prodapt.com");
	                message.setText("Hi, you have successfully completed the course ");
	                sender.send(message);     
	                return "Mail Sent Success!";
	}
	 
	 
	 



}
