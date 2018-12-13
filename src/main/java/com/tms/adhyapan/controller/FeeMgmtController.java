package com.tms.adhyapan.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FeeMgmtController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/collectTutionFeeLandingPage")
	public ModelAndView collectTutionFeeLandingPage(HttpServletRequest request) {
		LOGGER.info("Inside collectTutionFeeLandingPage");
		ModelAndView mv = new ModelAndView("collect-tution-fee");
		return mv;
	}
}
