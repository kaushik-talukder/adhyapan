package com.tms.adhyapan.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tms.adhyapan.service.IReportService;
import com.tms.adhyapan.vo.RegistrationFeeReportVO;
import com.tms.adhyapan.vo.TutionFeeClassReportVO;

@Controller
public class ReportController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IReportService reportService;
	
	@RequestMapping(value = "/tutionFeeReports")
	public ModelAndView tutionFeeReports(HttpServletRequest request) {
		LOGGER.info("Inside tutionFeeReports");
		ModelAndView mv = new ModelAndView("reports/tution-fee-reports");
		return mv;
	}
	
	@RequestMapping(value = "/registrationFeeReports")
	public ModelAndView registrationFeeReports(HttpServletRequest request) {
		LOGGER.info("Inside registrationFeeReports");
		ModelAndView mv = new ModelAndView("reports/registration-fee-reports");
		return mv;
	}
	
	@RequestMapping(value = "/getRegFeeReportByDateRange")
	public String getRegFeeReportByDateRange(Model model, @RequestParam(value = "pageFragment") String pageFragment,
			@RequestParam(value = "startDate") Date startDate,
			@RequestParam(value = "endDate") Date endDate) {
		RegistrationFeeReportVO registrationFeeReport = reportService.getRegistrationFeeReport(startDate, endDate);
		model.addAttribute("registrationFeeReport", registrationFeeReport);
		return pageFragment;
	}
	
	@RequestMapping(value = "/getTutionFeeClassReport")
	public String getTutionFeeClassReport(Model model, @RequestParam(value = "pageFragment") String pageFragment,
			@RequestParam(value = "classId") Long classId,
			@RequestParam(value = "monthCode") String monthCode) {
		TutionFeeClassReportVO tutionFeeClassReport = reportService.getTutionFeeClassReport(classId, monthCode);
		model.addAttribute("tutionFeeClassReport", tutionFeeClassReport);
		return pageFragment;
	}
}
