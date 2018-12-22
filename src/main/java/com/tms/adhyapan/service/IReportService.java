package com.tms.adhyapan.service;

import java.util.Date;

import com.tms.adhyapan.vo.RegistrationFeeReportVO;
import com.tms.adhyapan.vo.TutionFeeClassReportVO;

public interface IReportService {
	RegistrationFeeReportVO getRegistrationFeeReport(Date startDate, Date endDate);
	TutionFeeClassReportVO getTutionFeeClassReport(Long classId, String monthCode);
}
