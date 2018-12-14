package com.tms.adhyapan.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

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
	@Formula(value = "(select s.subject_name from subject s where s.id = subject_id)")
	private String subjectName;
	
	private Long centerId;
	@Formula(value = "(select c.name from center c where c.id = center_id)")
	private String centerName;
	
	@Formula(value = "(select concat(t.teacher_code, ' - ', t.first_name, ' ', t.last_name) from teacher t where t.id = teacher_id)")
	private String teacherName;
	private Long teacherId;
	
	private Long standardId;
	@Formula(value = "(select stnd.standard from standard stnd where stnd.id = standard_id)")
	private String standard; 
	private Double fee;
	
	private Date startDate = CommonUtils.getCurrentSystemDate();
	private Date endDate = CommonUtils.getDefaultEndDate();
}
