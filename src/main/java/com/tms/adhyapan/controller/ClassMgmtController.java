package com.tms.adhyapan.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tms.adhyapan.dao.repository.ClassRepository;

@Controller
public class ClassMgmtController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ClassRepository classRepository;
	
	@RequestMapping(value = "/createClassLandingPage")
	public ModelAndView createClassLandingPage(HttpServletRequest request) {
		LOGGER.info("Inside createClassLandingPage");
		ModelAndView mv = new ModelAndView("create-class");
		return mv;
	}
}
