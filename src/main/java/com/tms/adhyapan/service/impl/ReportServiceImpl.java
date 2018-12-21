package com.tms.adhyapan.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.adhyapan.dao.entity.FeeTxn;
import com.tms.adhyapan.dao.repository.FeeTxnRepository;
import com.tms.adhyapan.service.IReportService;
import com.tms.adhyapan.util.CommonConstants;
import com.tms.adhyapan.vo.RegistrationFeeReportVO;
import com.tms.adhyapan.vo.StudentFeeTxnVO;
import com.tms.adhyapan.vo.SummaryReportVO;

@Service
public class ReportServiceImpl implements IReportService {
	
	@Autowired
	private FeeTxnRepository feeTxnRepository;

	@Override
	public RegistrationFeeReportVO getRegistrationFeeReport(Date startDate, Date endDate) {
		RegistrationFeeReportVO registrationFeeReport = new RegistrationFeeReportVO();
		SummaryReportVO summaryReport = feeTxnRepository.getRegFeeSummaryReport(CommonConstants.FEE_CAT_REGISTRATION, startDate, endDate);
		List<FeeTxn> feeTxnList = feeTxnRepository.getFeeTxnByFeeCategoryIdAndTxnDateBetween(CommonConstants.FEE_CAT_REGISTRATION, startDate, endDate);
		List<StudentFeeTxnVO> studentFeeTxnList = new ArrayList<>();
		for(FeeTxn feeTxn : feeTxnList) {
			studentFeeTxnList.add(StudentFeeTxnVO.builder()
					.studentFirstName(feeTxn.getStudent().getFirstName())
					.studentLastName(feeTxn.getStudent().getFirstName())
					.standard(feeTxn.getStudent().getStandard().getStandard())
					.feeAmount(feeTxn.getFeeAmount())
					.remarks(feeTxn.getRemarks())
					.txnDate(feeTxn.getTxnDate())
					.build());
		}
		registrationFeeReport.setSummary(summaryReport);
		registrationFeeReport.setStudentFeeTxnList(studentFeeTxnList);
		return registrationFeeReport;
	}
}
