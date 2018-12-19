package com.tms.adhyapan.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.adhyapan.dao.repository.FeeTxnRepository;
import com.tms.adhyapan.service.IReportService;
import com.tms.adhyapan.vo.RegistrationFeeReportVO;

@Service
public class ReportServiceImpl implements IReportService {
	
	@Autowired
	private FeeTxnRepository feeTxnRepository;

	@Override
	public RegistrationFeeReportVO getRegistrationFeeReport(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
