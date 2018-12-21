package com.tms.adhyapan.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SummaryReportVO {
	private Long count;
	private Double totalCollectedFee;
	
	public SummaryReportVO(Long count, Double totalFee) {
		this.count = count;
		this.totalCollectedFee = totalFee;
	}
}
