package com.tms.adhyapan.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.adhyapan.dao.entity.FeeTxn;
import com.tms.adhyapan.dao.repository.FeeTxnRepository;
import com.tms.adhyapan.dao.repository.StudentClassRepository;
import com.tms.adhyapan.service.IReportService;
import com.tms.adhyapan.util.CommonConstants;
import com.tms.adhyapan.vo.RegistrationFeeReportVO;
import com.tms.adhyapan.vo.StudentFeeTxnVO;
import com.tms.adhyapan.vo.SummaryReportVO;
import com.tms.adhyapan.vo.TutionFeeClassReportVO;

@Service
public class ReportServiceImpl implements IReportService {
	
	@Autowired
	private FeeTxnRepository feeTxnRepository;
	@Autowired
	private StudentClassRepository studentClassRepository;

	@Override
	public RegistrationFeeReportVO getRegistrationFeeReport(Date startDate, Date endDate) {
		RegistrationFeeReportVO registrationFeeReport = new RegistrationFeeReportVO();
		SummaryReportVO summaryReport = feeTxnRepository.getRegFeeSummaryReport(CommonConstants.FEE_CAT_REGISTRATION, startDate, endDate);
		List<FeeTxn> feeTxnList = feeTxnRepository.getFeeTxnByCategoryIdAndTxnDateBetween(CommonConstants.FEE_CAT_REGISTRATION, startDate, endDate);
		List<StudentFeeTxnVO> studentFeeTxnList = new ArrayList<>();
		for(FeeTxn feeTxn : feeTxnList) {
			studentFeeTxnList.add(StudentFeeTxnVO.builder()
					.firstName(feeTxn.getStudent().getFirstName())
					.lastName(feeTxn.getStudent().getLastName())
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

	@Override
	public TutionFeeClassReportVO getTutionFeeClassReport(Long classId, String monthCode) {

		TutionFeeClassReportVO tutionFeeClassReport = new TutionFeeClassReportVO();
		SummaryReportVO summaryReport = feeTxnRepository.getTutionFeeClassSummaryReport(CommonConstants.FEE_CAT_TUTION, classId, monthCode);
		Long totalStudentCount = studentClassRepository.getActiveStudentCountByClassIdAndMonth(classId, monthCode);
		List<FeeTxn> feeTxnList = feeTxnRepository.getFeeTxnClassByCategoryIdAndMonthCode(CommonConstants.FEE_CAT_TUTION, classId, monthCode);
		summaryReport.setStudentCount(totalStudentCount);
		summaryReport.setPendingStudentCount(totalStudentCount - summaryReport.getPaidStudentCount());
		tutionFeeClassReport.setSummary(summaryReport);
		List<StudentFeeTxnVO> studentFeeTxnList = new ArrayList<>();
		for(FeeTxn feeTxn : feeTxnList) {
			studentFeeTxnList.add(StudentFeeTxnVO.builder()
					.firstName(feeTxn.getStudent().getFirstName())
					.lastName(feeTxn.getStudent().getLastName())
					.standard(feeTxn.getStudent().getStandard().getStandard())
					.feeAmount(feeTxn.getFeeAmount())
					.remarks(feeTxn.getRemarks())
					.txnDate(feeTxn.getTxnDate())
					.build());
		}
		tutionFeeClassReport.setSummary(summaryReport);
		tutionFeeClassReport.setStudentFeeTxnList(studentFeeTxnList);
		return tutionFeeClassReport;
	}
}
