package com.tms.adhyapan.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import com.tms.adhyapan.util.CommonConstants;
import com.tms.adhyapan.util.CommonUtils;

import lombok.Data;

@Entity
@Data
public class Student implements Serializable {

	private static final long serialVersionUID = 8068204045066759632L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String studentCode;
	private String firstName;
	private String lastName;
	private Long schoolId;
	@Formula(value = "(select s.school_name from school s where s.id = school_id)")
	private String schoolName;
	private Long standardId;
	@Formula(value = "(select std.standard from standard std where std.id = standard_id)")
	private String standard;
	private String studentContact;
	private String guardianName;
	private String guardianContact;
	private String address;
	private String gender;
	private Date startDate = CommonUtils.getCurrentSystemDate();
	private Date endDate = CommonUtils.getDefaultEndDate();
	
	@Transient
	private String activeFlag;
	
	public String getActiveFlag() {
		String flag = CommonConstants.ACTIVE_NO; 
		if(endDate.after(CommonUtils.getCurrentSystemDate())) {
			flag = CommonConstants.ACTIVE_YES;
		}
		return flag;
	}
}
