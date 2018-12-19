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
import javax.persistence.Transient;

import com.tms.adhyapan.util.CommonConstants;
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
	private Long subjectId;
	private Date startDate = CommonUtils.getCurrentSystemDate();
	private Date endDate = CommonUtils.getDefaultEndDate();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subjectId", referencedColumnName = "id", insertable = false, updatable = false)
	private Subject subject;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schoolId", referencedColumnName = "id", insertable = false, updatable = false)
	private School school;
	
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
