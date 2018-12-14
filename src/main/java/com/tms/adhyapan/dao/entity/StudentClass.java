package com.tms.adhyapan.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tms.adhyapan.util.CommonUtils;

import lombok.Data;

@Entity
@Data
public class StudentClass implements Serializable {

	private static final long serialVersionUID = 894575941590867247L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long classId;
	private Long studentId;
	private Date startDate = CommonUtils.getCurrentSystemDate();
	private Date endDate = CommonUtils.getDefaultEndDate();
}
