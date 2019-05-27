package com.prodapt.ctlacademy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.prodapt.ctlacademy.model.ElContent;
import com.prodapt.ctlacademy.model.ElUser;
import com.prodapt.ctlacademy.model.ElUserIndex;
import com.prodapt.ctlacademy.repository.ElUserDetailsRepository;
import com.prodapt.ctlacademy.service.ElUserService;


@RestController
@CrossOrigin("*")

@RequestMapping("/user")
public class ElUserDetailsController {

	
	@Autowired
	ElUserDetailsRepository elUserDetailsRepository;
//	
//	@Autowired
//	ElUserService elUserService; 

	@PersistenceContext
	EntityManager entityManager;
	
	
	@PostMapping("save")
	public ElUser save(@RequestBody ElUser elcc) {
		 
		return this.elUserDetailsRepository.save(elcc);

	}
	
	
	@PostMapping("validatedusers")
	public Boolean validateUser(@RequestBody ElUser r) {
		ElUser user=elUserDetailsRepository.findByElEmpIdAndElUcourseId(r.getElEmpId(),r.getElUcourseId());
		boolean statusmsg = false;
		if(user!=null) {
			statusmsg=true;
			return statusmsg;
		}else {
			return statusmsg;
		}
	}

    @Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = { "/content", "" }, method = RequestMethod.GET)
	public Map getDetails(@RequestParam Integer code,@RequestParam Integer id )
	 
	{
    	Map<String,String> map=new HashMap<String, String>();
		ElContent list = new  ElContent();
		
		
	     Query query = entityManager.createNativeQuery( "select el_content from ctlacademy.el_course_content c,ctlacademy.el_user_details u where u.el_empid="+code+" and c.el_course_id="+id,ElContent.class);
	       list = (ElContent) query.getSingleResult();
	       
         Query query1 = entityManager.createNativeQuery( "select el_page_index from ctlacademy.el_user_details where el_empid="+code+" and el_ucourse_id="+id);
	     String[] contentArray=list.getElCourseContent().split(";");
	     
	         Integer content = Integer.parseInt(query1.getSingleResult().toString());
	         if(content==0) 
	         {
	         map.put("isFirstSlide", Boolean.TRUE.toString());
	         }
	         
	         if((content+1) == contentArray.length)
	         {
	       	 map.put("isLastSlide", Boolean.TRUE.toString());
	         }
	         
             map.put("slide", contentArray[content]);
	         System.out.println("***** CONTENT *****: " + content); 
	         System.out.println();
	         
	         String [] splitedContent = list.getElCourseContent().split(";");
	
	         return map;
	       
	     
	       
	}

    
//    Previous button
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
	@RequestMapping("prev")
	public String ElUser(int code,int id)
	  {  
	     Query query2 = entityManager.createNativeQuery( "select el_page_index from ctlacademy.el_user_details where el_empid="+code+" and el_ucourse_id="+id);
	    
	     Integer contentprev = Integer.parseInt(query2.getSingleResult().toString()); 
	     contentprev--;
	    
	     Query query3 = entityManager.createNativeQuery( "UPDATE `el_user_details` SET `el_page_index` =" + contentprev + " WHERE el_empid= " + code + " and el_ucourse_id=" + id);
	         
	     int statuschange = query3.executeUpdate();
	        
	     System.out.println("*****PREV VALUE *****" + statuschange);
	      
         RestTemplate rt=new RestTemplate();
         String output = rt.getForObject("http://localhost:8080/user/content?code="+code+"&id="+id, String.class);
	         
	     System.out.println("***** OUTPUT PREV *****" + output);
         System.out.println();
         return  output; 	
	}
    
    
    
//    Next Button
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
	@RequestMapping("next")
	public String ElUser1(int code,int id)
	{  
		
		 Query query4 = entityManager.createNativeQuery("select el_page_index from ctlacademy.el_user_details where el_empid=" + code + " and el_ucourse_id=" + id);

	     Integer contentnext = Integer.parseInt(query4.getSingleResult().toString()); 
	     ++contentnext;
	    
	     Query query5 = entityManager.createNativeQuery("UPDATE `el_user_details` SET `el_page_index` =" + contentnext + " WHERE el_empid= " + code + " and el_ucourse_id=" + id);
	         
	     int statuschangenext = query5.executeUpdate(); 
	         
	        
	     System.out.println("*****NEXT VALUE *****" + statuschangenext);
	         
	     Query query1 = entityManager.createNativeQuery( "select el_page_index from ctlacademy.el_user_details where el_empid="+code+" and el_ucourse_id="+id);
	         
	     Integer content = Integer.parseInt(query1.getSingleResult().toString());
         System.out.println("*****  *****: " + content); 

         RestTemplate rtnew=new RestTemplate();
	     String outputnext = rtnew.getForObject("http://localhost:8080/user/content?code="+code+"&id="+id, String.class);
         System.out.println("***** OUTPUT NEXT *****" + outputnext);
         System.out.println();
	         return  outputnext; 	
	}

    
    @Autowired
    private Environment env;
     	
    	@GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    		public @ResponseBody byte[] getImage(@RequestParam("image") String image) throws IOException {
    			String filePath = this.env.getProperty("application.base.media") + image;
    		    InputStream in = new FileInputStream(new File(filePath));
    		    return IOUtils.toByteArray(in);
    		} 
    	 

    	
    	
//   	 for fetchiing the status
    	@RequestMapping("status")
    	public String ElStatus(@RequestParam int code,@RequestParam int id) {
   			 
   			 Query query1 = entityManager.createNativeQuery( "select el_nom_status from ctlacademy.el_nomi where el_emp_id="+code+" and el_nom_course_id="+id);
			String result= (String) query1.getSingleResult();
			System.out.println(result);
			return result;
			
    	}
    	
//    	For Fetching the index
    	@RequestMapping("index")
	 	public List Elindex(@RequestParam int code,@RequestParam int id) {
  			 
	 		 Query query2 = entityManager.createNativeQuery( "select el_page_index from ctlacademy.el_user_details where el_empid="+code+" and el_ucourse_id="+id,ElUserIndex.class);
	  	    
	 		List index =query2.getResultList();
			System.out.println(index);
			return index;
			
			
   	}

}
