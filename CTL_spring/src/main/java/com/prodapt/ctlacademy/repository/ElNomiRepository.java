package com.prodapt.ctlacademy.repository;




	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.prodapt.ctlacademy.model.ElNomination;
import com.prodapt.ctlacademy.model.ElUser;

	@Repository
	public interface ElNomiRepository  extends JpaRepository<ElNomination,Integer>{

	

		ElNomination findByElNomEmpIdAndElNomCourseId(int elNomEmpId, int elNomCourseId);

		

	

	}

