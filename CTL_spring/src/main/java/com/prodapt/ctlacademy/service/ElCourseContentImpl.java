package com.prodapt.ctlacademy.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.prodapt.ctlacademy.model.ElCourseContent;
import com.prodapt.ctlacademy.repository.ElCourseContentRepository;

@Service
@Transactional
public class ElCourseContentImpl implements ElCourseService {
	ElCourseContentRepository elCourseContentRepository;

	public ElCourseContentImpl(ElCourseContentRepository elCourseContentRepository) {
		// TODO Auto-generated constructor stub
		this.elCourseContentRepository = elCourseContentRepository;
	}

	@Override
	public List<ElCourseContent> getAll() {
		return elCourseContentRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ElCourseContent save(ElCourseContent content) {

//                     return elCourseContentRepository.save(el);
		return elCourseContentRepository.save(content);
	}

}
