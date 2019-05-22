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

@Table(name="el_user_details")
public class ElUserIndex {
 
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	 @Column(name="el_page_index")
	    private int	 elPageIndex;

	public int getElPageIndex() {
		return elPageIndex;
	}

	public void setElPageIndex(int elPageIndex) {
		this.elPageIndex = elPageIndex;
	}
	 
}
