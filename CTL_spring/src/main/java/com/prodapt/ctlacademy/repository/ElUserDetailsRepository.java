package com.prodapt.ctlacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.ctlacademy.model.ElUser;

@Repository
public interface ElUserDetailsRepository extends JpaRepository<ElUser,Integer>{

	ElUser findByElEmpIdAndElUcourseId(int elEmpId, int elUcourseId);


	

}


