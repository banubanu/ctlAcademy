package com.prodapt.ctlacademy.model;


	import java.sql.Date;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

	import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
	@Entity
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@Table(name="el_nomi")
	public class ElNomination {

	    @Id
	    @Column(name="el_nom_id")
	     private int id;
	     
	    @Column(name="el_emp_id")
	    private int elNomEmpId ;
	    
	    @Column(name="el_nom_emp_name")
	  	private String elNomEmpName ;
	    
	    @Column(name="el_nom_emp_mail")
	  	private String elNomEmpMail;
	    
	    @Column(name="el_nom_course_id")
	  	private int elNomCourseId;
	     
	    @Column(name="el_nom_status")
	  	private String elNomStatus ;
	    
	    @Column(name="el_nom_date")
	  	private String elNomDate ;
	    
	    @Column(name="el_nom_course")
	  	private String elNomCourse;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getElNomEmpId() {
			return elNomEmpId;
		}

		public void setElNomEmpId(int elNomEmpId) {
			this.elNomEmpId = elNomEmpId;
		}

		public String getElNomEmpName() {
			return elNomEmpName;
		}

		public void setElNomEmpName(String elNomEmpName) {
			this.elNomEmpName = elNomEmpName;
		}

		public String getElNomEmpMail() {
			return elNomEmpMail;
		}

		public void setElNomEmpMail(String elNomEmpMail) {
			this.elNomEmpMail = elNomEmpMail;
		}

		public int getElNomCourseId() {
			return elNomCourseId;
		}

		public void setElNomCourseId(int elNomCourseId) {
			this.elNomCourseId = elNomCourseId;
		}

		public String getElNomStatus() {
			return elNomStatus;
		}

		public void setElNomStatus(String elNomStatus) {
			this.elNomStatus = elNomStatus;
		}

		public String getElNomDate() {
			return elNomDate;
		}

		public void setElNomDate(String elNomDate) {
			this.elNomDate = elNomDate;
		}

		public String getElNomCourse() {
			return elNomCourse;
		}

		public void setElNomCourse(String elNomCourse) {
			this.elNomCourse = elNomCourse;
		}



		

		
	}