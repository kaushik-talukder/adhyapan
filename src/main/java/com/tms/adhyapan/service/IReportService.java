package com.tms.adhyapan.service;

import java.util.Date;

import com.tms.adhyapan.vo.RegistrationFeeReportVO;

public interface IReportService {
	RegistrationFeeReportVO getRegistrationFeeReport(Date startDate, Date endDate);
}
