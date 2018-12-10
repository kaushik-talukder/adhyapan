package com.tms.adhyapan.dao.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Formula;

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
	
	private String studentContact;
	private String guardianName;
	private String guardianContact;
	private String address;
	private String gender;
	private Timestamp startDate;
	private Timestamp endDate;
}
