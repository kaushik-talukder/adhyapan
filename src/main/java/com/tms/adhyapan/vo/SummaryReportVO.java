package com.tms.adhyapan.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SummaryReportVO {
	private Long totalStudentCount;
	private Long totalPaidStudentCount;
	private Long totalClassCount;
	private Double totalCollectedFee;
	
	public SummaryReportVO(Long totalStudentCount, Double totalFee) {
		this.totalStudentCount = totalStudentCount;
		this.totalCollectedFee = totalFee;
	}

	public SummaryReportVO(Long totalStudentCount, Long totalPaidStudentCount, Long totalClassCount,
			Double totalCollectedFee) {
		this.totalStudentCount = totalStudentCount;
		this.totalPaidStudentCount = totalPaidStudentCount;
		this.totalClassCount = totalClassCount;
		this.totalCollectedFee = totalCollectedFee;
	}
}
