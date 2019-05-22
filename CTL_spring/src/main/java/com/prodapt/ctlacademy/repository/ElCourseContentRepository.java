package com.prodapt.ctlacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.ctlacademy.model.ElCourseContent;

@Repository
public interface ElCourseContentRepository extends JpaRepository<ElCourseContent,Integer>{

}
