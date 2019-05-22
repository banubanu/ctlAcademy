package com.prodapt.ctlacademy.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.prodapt.ctlacademy.model.ElCourseComp;
import com.prodapt.ctlacademy.repository.ElCourseCompRepository;

@Service
public class ElCourseCompImpl  implements ElCourseCompService {
	ElCourseCompRepository elCourseCompRepository;
       
       public ElCourseCompImpl(ElCourseCompRepository elCourseCompRepository) {
              // TODO Auto-generated constructor stub
              this.elCourseCompRepository = elCourseCompRepository;
       }
       
       @Override
       public List<ElCourseComp> getAll(){
              // TODO Auto-generated method stub
              return elCourseCompRepository.findAll();
       }

       @Override
       public ElCourseComp save(ElCourseComp ec) {
              // TODO Auto-generated method stub
              return elCourseCompRepository.save(ec);
       }
       
       

}
