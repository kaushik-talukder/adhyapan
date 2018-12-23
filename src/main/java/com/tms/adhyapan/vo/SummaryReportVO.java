package com.tms.adhyapan.vo;

import lombok.Data;

@Data
public class SummaryReportVO {
	private Long studentCount;
	private Long paidStudentCount;
	private Long classCount;
	private Double collectedFee;
	private Long pendingStudentCount;
	
	public SummaryReportVO(Long paidStudentCount, Double totalFee) {
		this.paidStudentCount = paidStudentCount;
		this.collectedFee = totalFee;
	}
}
