package com.prodapt.ctlacademy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="el_course_content")
public class ElContent {


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	   
	    
	    @Column(name="el_content")
	  	private String elCourseContent;
	    
		



		public String getElCourseContent() {
			return elCourseContent;
		}

		public void setElCourseContent(String elCourseContent) {
			this.elCourseContent = elCourseContent;
		}
	    
	    
}
