package com.prodapt.ctlacademy.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="el_course_comp")
public class ElCourseComp {
    @Id
    @Column(name="el_comp_id")
     private int id;
     

    @Column(name="el_emp_id")
  	private String elEmpId ;
    
    @Column(name="el_comp_course_id")
  	private String elCompCourseId;
    
    @Column(name="el_cert_generation")
  	private int elCertGeneration;
     
    @Column(name="el_comp_course_name")
  	private String elCompCourseName ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getElEmpId() {
		return elEmpId;
	}

	public void setElEmpId(String elEmpId) {
		this.elEmpId = elEmpId;
	}

	public String getElCompCourseId() {
		return elCompCourseId;
	}

	public void setElCompCourseId(String elCompCourseId) {
		this.elCompCourseId = elCompCourseId;
	}

	public int getElCertGeneration() {
		return elCertGeneration;
	}

	public void setElCertGeneration(int elCertGeneration) {
		this.elCertGeneration = elCertGeneration;
	}

	public String getElCompCourseName() {
		return elCompCourseName;
	}

	public void setElCompCourseName(String elCompCourseName) {
		this.elCompCourseName = elCompCourseName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + elCertGeneration;
		result = prime * result + ((elCompCourseId == null) ? 0 : elCompCourseId.hashCode());
		result = prime * result + ((elCompCourseName == null) ? 0 : elCompCourseName.hashCode());
		result = prime * result + ((elEmpId == null) ? 0 : elEmpId.hashCode());
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
		ElCourseComp other = (ElCourseComp) obj;
		if (elCertGeneration != other.elCertGeneration)
			return false;
		if (elCompCourseId == null) {
			if (other.elCompCourseId != null)
				return false;
		} else if (!elCompCourseId.equals(other.elCompCourseId))
			return false;
		if (elCompCourseName == null) {
			if (other.elCompCourseName != null)
				return false;
		} else if (!elCompCourseName.equals(other.elCompCourseName))
			return false;
		if (elEmpId == null) {
			if (other.elEmpId != null)
				return false;
		} else if (!elEmpId.equals(other.elEmpId))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ElCourseComp [id=" + id + ", elEmpId=" + elEmpId + ", elCompCourseId=" + elCompCourseId
				+ ", elCertGeneration=" + elCertGeneration + ", elCompCourseName=" + elCompCourseName + "]";
	}
    
    
    
}

