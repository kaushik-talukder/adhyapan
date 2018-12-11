package com.tms.adhyapan.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import com.tms.adhyapan.util.CommonConstants;
import com.tms.adhyapan.util.CommonUtils;

import lombok.Data;

@Entity
@Data
@Table(name = "class")
public class Clazz implements Serializable {
 
	private static final long serialVersionUID = -1558838374123302898L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long subjectId;
	@Formula(value = "(select s.subject_name from subject s where s.id = subject_id)")
	private String subjectName;
	
	private Long teacherId;
	private Long standardId;
	private Long centerId;
	private Date startDate = CommonUtils.getDefaultStartDate();
	private Date endDate = CommonUtils.getDefaultEndDate();
	private String isActive = CommonConstants.ACTIVE_YES;
}
