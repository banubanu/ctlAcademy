package com.prodapt.ctlacademy.service;

import com.prodapt.ctlacademy.model.ElUser;
import com.prodapt.ctlacademy.repository.ElUserDetailsRepository;

public class ElUserServiceImpl implements ElUserService {
  ElUserDetailsRepository elUserDetailsRepository;
  
  
  public ElUserServiceImpl(  ElUserDetailsRepository elUserDetailsRepository) {
	  this.elUserDetailsRepository=elUserDetailsRepository;
  }

  
  public ElUser save(ElUser user) {

//    return elCourseContentRepository.save(el);
       return elUserDetailsRepository.save(user);
}


//@Override
//public ElUser findByElEmpIdAndelUcourseId(int elEmpId, int elUcourseId) {
//	// TODO Auto-generated method stub
//	return null;
//}
}
