
package com.prodapt.ctlacademy.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.ctlacademy.model.ElCourseComp;

@Repository
public interface ElCourseCompRepository  extends JpaRepository<ElCourseComp,Integer>{

}

