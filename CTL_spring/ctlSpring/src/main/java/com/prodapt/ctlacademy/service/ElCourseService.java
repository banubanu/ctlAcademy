package com.prodapt.ctlacademy.service;

import java.util.List;

import com.prodapt.ctlacademy.model.ElCourseContent;

public interface ElCourseService {

	List<ElCourseContent> getAll();

	ElCourseContent save(ElCourseContent content);
	
 
	
}
