package com.prodapt.ctlacademy.repository;




	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.prodapt.ctlacademy.model.ElNomination;

	@Repository
	public interface ElNomiRepository  extends JpaRepository<ElNomination,Integer>{

	}

