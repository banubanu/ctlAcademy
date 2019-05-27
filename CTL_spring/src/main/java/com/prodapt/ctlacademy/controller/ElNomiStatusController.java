package com.prodapt.ctlacademy.controller;


	import java.util.Date;
	import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.ctlacademy.model.ElNomination;
import com.prodapt.ctlacademy.model.ElUser;
import com.prodapt.ctlacademy.repository.ElNomiRepository;

import com.prodapt.ctlacademy.service.ElNomiService;


	@RestController
	@CrossOrigin("*")
	@RequestMapping("/addnomi")
	
	public class ElNomiStatusController {
		
		@Autowired
		ElNomiService elNomiService;
		
		@Autowired
		ElNomiRepository elNomiRepository;
		

		@PersistenceContext
		EntityManager entityManager;

		
		public ElNomiStatusController(ElNomiService elNomiService ) {
			this.elNomiService=elNomiService;
		}
		
//		@RequestMapping(value="/save", method= RequestMethod.POST)
	//	
//		public ElCourseContent save(@RequestBody ElCourseContent elcc)
//		{
//			
//			return elCourseContentService.save(elcc);
//		}
		
		@GetMapping("get")
		public List<ElNomination> getAll() {
			 
			return this.elNomiRepository.findAll();

		}
		
		@PostMapping("validateUsersForNomination")
		public Boolean validateUser(@RequestBody ElNomination r) {
			ElNomination user=elNomiRepository.findByElNomEmpIdAndElNomCourseId(r.getElNomEmpId(),r.getElNomCourseId());
			boolean statusmsg = false;
			if(user!=null) {
				statusmsg=true;
				return statusmsg;
			}else {
				return statusmsg;
			}
		}

		
		@PostMapping("save")
		public ElNomination save(@RequestBody ElNomination elnom) {
			 
			return this.elNomiRepository.save(elnom);

		}
		
		@Transactional
		@RequestMapping("StatusChange")
		public int ElNomination(@RequestBody ElNomination elNomination) {  
		    Query query = entityManager.createNativeQuery(
		    		   "UPDATE `el_nomi` SET `el_nom_status` = '" + elNomination.getElNomStatus() + "'  WHERE el_nom_course_id= '" + elNomination.getElNomCourseId()+ "'",  ElNomination.class);
		         int statuschange = query.executeUpdate(); 
		         return  statuschange;
		}
		

		}

	