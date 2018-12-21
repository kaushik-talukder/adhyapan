package com.tms.adhyapan.vo;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentFeeTxnVO {
	private String studentFirstName;
	private String studentLastName;
	private String standard;
	private Double feeAmount;
	private Date txnDate;
	private String remarks;
}
