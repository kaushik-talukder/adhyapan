package com.tms.adhyapan.dao.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class School implements Serializable {

	private static final long serialVersionUID = 9026165336457838701L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String schoolName;
	private String schoolCode;
	private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
	private Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
}
