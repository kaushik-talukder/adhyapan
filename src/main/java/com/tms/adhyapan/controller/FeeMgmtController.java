package com.tms.adhyapan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tms.adhyapan.dao.entity.FeeTxn;
import com.tms.adhyapan.dao.repository.FeeTxnRepository;
import com.tms.adhyapan.util.CommonConstants;

@Controller
public class FeeMgmtController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FeeTxnRepository feeTxnRepository;
	
	@RequestMapping(value = "/collectTutionFeeLandingPage")
	public ModelAndView collectTutionFeeLandingPage(HttpServletRequest request) {
		LOGGER.info("Inside collectTutionFeeLandingPage");
		ModelAndView mv = new ModelAndView("collect-tution-fee");
		mv.addObject("feeCategoryId", CommonConstants.FEE_CAT_TUTION);
		return mv;
	}
	
	@RequestMapping(value = "/collectRegistrationFeeLandingPage")
	public ModelAndView collectRegistrationFeeLandingPage(HttpServletRequest request) {
		LOGGER.info("Inside collectRegistrationFeeLandingPage");
		ModelAndView mv = new ModelAndView("collect-registration-fee");
		mv.addObject("feeCategoryId", CommonConstants.FEE_CAT_REGISTRATION);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveTutionFee")
	public List<FeeTxn> saveTutionFee(@RequestBody List<FeeTxn> feeTxnList) {
		List<FeeTxn> savedTxnList = feeTxnRepository.saveAll(feeTxnList);
		return savedTxnList;
	}
}
