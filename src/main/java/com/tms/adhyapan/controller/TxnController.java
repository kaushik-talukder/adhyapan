package com.tms.adhyapan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tms.adhyapan.dao.entity.FeeTxn;
import com.tms.adhyapan.dao.repository.FeeTxnRepository;
import com.tms.adhyapan.util.CommonConstants;

@Controller
public class TxnController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FeeTxnRepository feeTxnRepository;
	
	@RequestMapping(value = "/populateStudentFeeTxnDetails")
	public String populateStudentFeeTxnDetails(Model model, @RequestParam(value = "pageFragment") String pageFragment,
			@RequestParam(value = "studentId") Long studentId,
			@RequestParam(value = "classId") Long classId) {
		LOGGER.info("Inside populateStudentFeePayementDetails");
		List<FeeTxn> feeTxnList = feeTxnRepository.findByStudentIdAndClassIdAndFeeCategoryIdOrderByTxnDateDesc(studentId, classId, CommonConstants.FEE_CAT_TUTION);
		model.addAttribute("feeTxnList", feeTxnList);
		return pageFragment;
	}
}
