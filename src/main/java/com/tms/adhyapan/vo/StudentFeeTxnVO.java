package com.tms.adhyapan.vo;

import java.util.Date;

import lombok.Data;

@Data
public class StudentFeeTxnVO {
	private String studentFirstName;
	private String studentLastName;
	private String standard;
	private String feeAmount;
	private Date txnDate;
	private String remarks;
}
