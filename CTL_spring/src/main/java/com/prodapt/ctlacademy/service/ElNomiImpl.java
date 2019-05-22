
	package com.prodapt.ctlacademy.service;
    import java.util.List;
    import org.springframework.stereotype.Service;
    import com.prodapt.ctlacademy.model.ElNomination;
    import com.prodapt.ctlacademy.repository.ElNomiRepository;

    @Service
    public class ElNomiImpl implements ElNomiService {
    	ElNomiRepository elNomiRepository;
           
           public ElNomiImpl(ElNomiRepository elNomiRepository) {
                  // TODO Auto-generated constructor stub
                  this.elNomiRepository = elNomiRepository;
           }
           
           @Override
           public List<ElNomination> getAll() {
                  // TODO Auto-generated method stub
                  return elNomiRepository.findAll();
           }

           @Override
           public ElNomination save(ElNomination en) {
                  // TODO Auto-generated method stub
                  return elNomiRepository.save(en);
           }
           
           

    }


