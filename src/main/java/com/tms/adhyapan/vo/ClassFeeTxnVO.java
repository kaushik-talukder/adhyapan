package com.tms.adhyapan.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassFeeTxnVO {
	private Long classId;
	private String classCode;
	private String teacherCode;
	private Long paidCount;
	private Long pendingCount;
	private Double feeAmount;
}
