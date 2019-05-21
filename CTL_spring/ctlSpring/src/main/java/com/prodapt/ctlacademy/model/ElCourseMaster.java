package com.prodapt.ctlacademy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="course_master")
public class ElCourseMaster {

	 	@Id
	    @Column(name="course_id")
	     private int id;
	 
	    @Column(name="course_name")
	  	private String elCourseName;
	    
	    @Column(name="course_description")
	  	private String elCourseDesc;
	     
	    @Column(name="course_image")
	  	private String elCourseImage ;
	    
	    @Column(name="course_by")
		private String elCourseBy ;
		    
	    @Column(name="course_creation_date")
	  	private Date elCreationDate;
	    
	    @Column(name="course_status")
	  	private boolean elCourseStatus;
	    
	
}
