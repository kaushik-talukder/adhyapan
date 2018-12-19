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
	
	@RequestMapping(value = "/tutionFeeReports")
	public ModelAndView tutionFeeReports(HttpServletRequest request) {
		LOGGER.info("Inside tutionFeeReports");
		ModelAndView mv = new ModelAndView("reports/tution-fee-reports");
		return mv;
	}
}
