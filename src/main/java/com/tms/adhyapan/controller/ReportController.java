package com.tms.adhyapan.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/reportHomePage")
	public ModelAndView reportHomePage(HttpServletRequest request) {
		LOGGER.info("Inside reportHomePage");
		ModelAndView mv = new ModelAndView("reports/report-home");
		return mv;
	}
}
