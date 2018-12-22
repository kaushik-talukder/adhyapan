package com.tms.adhyapan.vo;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentFeeTxnVO {
	private Long studentId;
	private String firstName;
	private String lastName;
	private String standard;
	private Double feeAmount;
	private Date txnDate;
	private String remarks;
}
