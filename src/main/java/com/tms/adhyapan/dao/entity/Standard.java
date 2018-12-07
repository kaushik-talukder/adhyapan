package com.tms.adhyapan.dao.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Standard implements Serializable {

	private static final long serialVersionUID = -6731269207404451565L;
	
	@Id
	private Long id;
	private String standard;
	private String description;
	private Date createdAt;
	private Date updatedAt;
}
