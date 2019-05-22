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
	     
//	    @Column(name="el_nom_emp_id")
//	    private String elNomEmpId ;
	    
	    @Column(name="el_nom_emp_name")
	  	private String elNomEmpName ;
	    
	    @Column(name="el_nom_emp_mail")
	  	private String elNomEmpMail;
	    
	    @Column(name="el_nom_course_id")
	  	private int elNomCourseId;
	     
	    @Column(name="el_nom_status")
	  	private String elNomStatus ;
	    
	    @Column(name="el_name")
	  	private String elName;
	    
	    @Column(name="el_rm_email")
	  	private String elRmEmail;
	    
	    @Column(name="el_nom_course")
	  	private String elNomCourse;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public String getElName() {
			return elName;
		}

		public void setElName(String elName) {
			this.elName = elName;
		}

		public String getElRmEmail() {
			return elRmEmail;
		}

		public void setElRmEmail(String elRmEmail) {
			this.elRmEmail = elRmEmail;
		}

		public String getElNomCourse() {
			return elNomCourse;
		}

		public void setElNomCourse(String elNomCourse) {
			this.elNomCourse = elNomCourse;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((elName == null) ? 0 : elName.hashCode());
			result = prime * result + ((elNomCourse == null) ? 0 : elNomCourse.hashCode());
			result = prime * result + elNomCourseId;
			result = prime * result + ((elNomEmpMail == null) ? 0 : elNomEmpMail.hashCode());
			result = prime * result + ((elNomEmpName == null) ? 0 : elNomEmpName.hashCode());
			result = prime * result + ((elNomStatus == null) ? 0 : elNomStatus.hashCode());
			result = prime * result + ((elRmEmail == null) ? 0 : elRmEmail.hashCode());
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ElNomination other = (ElNomination) obj;
			if (elName == null) {
				if (other.elName != null)
					return false;
			} else if (!elName.equals(other.elName))
				return false;
			if (elNomCourse == null) {
				if (other.elNomCourse != null)
					return false;
			} else if (!elNomCourse.equals(other.elNomCourse))
				return false;
			if (elNomCourseId != other.elNomCourseId)
				return false;
			if (elNomEmpMail == null) {
				if (other.elNomEmpMail != null)
					return false;
			} else if (!elNomEmpMail.equals(other.elNomEmpMail))
				return false;
			if (elNomEmpName == null) {
				if (other.elNomEmpName != null)
					return false;
			} else if (!elNomEmpName.equals(other.elNomEmpName))
				return false;
			if (elNomStatus == null) {
				if (other.elNomStatus != null)
					return false;
			} else if (!elNomStatus.equals(other.elNomStatus))
				return false;
			if (elRmEmail == null) {
				if (other.elRmEmail != null)
					return false;
			} else if (!elRmEmail.equals(other.elRmEmail))
				return false;
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "ElNomination [id=" + id + ", elNomEmpName=" + elNomEmpName + ", elNomEmpMail=" + elNomEmpMail
					+ ", elNomCourseId=" + elNomCourseId + ", elNomStatus=" + elNomStatus + ", elName=" + elName
					+ ", elRmEmail=" + elRmEmail + ", elNomCourse=" + elNomCourse + "]";
		}

		

		
	}