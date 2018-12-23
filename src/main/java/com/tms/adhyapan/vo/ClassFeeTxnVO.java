package com.tms.adhyapan.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ClassFeeTxnVO {

	private Long classId;
	private String classCode;
	private String teacherCode;
	private Long paidCount;
	private Long pendingCount;
	private Double feeAmount = 0.0;
	private Date txnDate;
	private String remarks = "";
	private String txnDateStr = "";

	public ClassFeeTxnVO() {}
	
	public ClassFeeTxnVO(Long classId, String classCode, Double feeAmount, Date txnDate, String remarks) {
		this.classId = classId;
		this.classCode = classCode;
		this.feeAmount = feeAmount;
		this.txnDate = txnDate;
		this.remarks = remarks;
	}
}
