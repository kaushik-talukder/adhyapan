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
import javax.persistence.Table;

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
	private String classCode;
	private Long subjectId;
	private Long centerId;
	private Long teacherId;
	private Long standardId;
	private Double fee;
	private Date startDate = CommonUtils.getCurrentSystemDate();
	private Date endDate = CommonUtils.getDefaultEndDate();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "standardId", referencedColumnName = "id", insertable = false, updatable = false)
	private Standard standard;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacherId", referencedColumnName = "id", insertable = false, updatable = false)
	private Teacher teacher;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "centerId", referencedColumnName = "id", insertable = false, updatable = false)
	private Center center;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subjectId", referencedColumnName = "id", insertable = false, updatable = false)
	private Subject subject;
}
