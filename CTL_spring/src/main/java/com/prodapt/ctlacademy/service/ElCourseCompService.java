
package com.prodapt.ctlacademy.service;


import java.util.List;

import com.prodapt.ctlacademy.model.ElCourseComp;


public interface ElCourseCompService {
       
              List<ElCourseComp> getAll();
              ElCourseComp save(ElCourseComp  ec);
       }
