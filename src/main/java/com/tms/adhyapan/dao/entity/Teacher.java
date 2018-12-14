package com.tms.adhyapan.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Formula;

import com.tms.adhyapan.util.CommonUtils;

import lombok.Data;

@Entity
@Data
public class Teacher implements Serializable {

	private static final long serialVersionUID = 4569152174501395948L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String teacherCode;
	private String contact;
	private String address;
	private Long schoolId;
	@Formula(value = "(select s.school_name from school s where s.id = school_id)")
	private String schoolName;
	private Long subjectId;
	@Formula(value = "(select s.subject_name from subject s where s.id = subject_id)")
	private String subjectName;
	private Date startDate = CommonUtils.getCurrentSystemDate();
	private Date endDate = CommonUtils.getDefaultEndDate();
}
