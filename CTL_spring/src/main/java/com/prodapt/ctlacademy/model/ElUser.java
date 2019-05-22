package com.prodapt.ctlacademy.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="el_user_details")
public class ElUser {


    @Id
    @Column(name="el_uid")
     private int id;
     
    @Column(name="el_empid")
    private int elEmpId;
    
    @Column(name="el_empname")
    private String elEmpName ;
    
    @Column(name="el_ucourse_id")
    private int elUcourseId ;
       
    @Column(name="el_userrole")
    private String elUserRole;
    
    @Column(name="el_user_date")
    private String elUserDate ;
    
    @Column(name="el_page_index")
    private int	 elPageIndex;
//
//    @ManyToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name="el_ucourse_id",referencedColumnName="el_course_id")
//    private ElUserContent elUserContent;

    
    
//    public ElUser(){}

    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getElEmpId() {
		return elEmpId;
	}

	public void setElEmpId(int elEmpId) {
		this.elEmpId = elEmpId;
	}

	public String getElEmpName() {
		return elEmpName;
	}

	public void setElEmpName(String elEmpName) {
		this.elEmpName = elEmpName;
	}

	public int getElUcourseId() {
		return elUcourseId;
	}

	public void setElUcourseId(int elUcourseId) {
		this.elUcourseId = elUcourseId;
	}

	public String getElUserRole() {
		return elUserRole;
	}

	public void setElUserRole(String elUserRole) {
		this.elUserRole = elUserRole;
	}

	public String getElUserDate() {
		return elUserDate;
	}

	public void setElUserDate(String elUserDate) {
		this.elUserDate = elUserDate;
	}

	public int getElPageIndex() {
		return elPageIndex;
	}

	public void setElPageIndex(int elPageIndex) {
		this.elPageIndex = elPageIndex;
	}
    
    
	
}
