package com.tms.adhyapan.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tms.adhyapan.dao.repository.SchoolRepository;
import com.tms.adhyapan.dao.repository.SubjectRepository;

@Controller
public class TeacherMgmtController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private SchoolRepository schoolRepository;
	
	@RequestMapping(value = "/registerTeacher")
	public ModelAndView registerTeacher(HttpServletRequest request) {
		LOGGER.info("Inside registerTeacher");
		ModelAndView mv = new ModelAndView("register-teacher");
		return mv;
	}
}
