package com.tms.adhyapan.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.tms.adhyapan.util.CommonUtils;

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
	private Date txnDate = CommonUtils.getCurrentSystemDate();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studentId", referencedColumnName = "id", insertable = false, updatable = false)
	private Student student;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classId", referencedColumnName = "id", insertable = false, updatable = false)
	private Clazz clazz;
}
