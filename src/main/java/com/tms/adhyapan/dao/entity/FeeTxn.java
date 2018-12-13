package com.tms.adhyapan.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class FeeTxn implements Serializable {

	private static final long serialVersionUID = 3844738922439252344L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long feeCategoryId;
	private Long studentId;
	private Long classId;
	private Long examId;
	private String monthCode;
	private Double feeAmount;
	private String remarks;
}
