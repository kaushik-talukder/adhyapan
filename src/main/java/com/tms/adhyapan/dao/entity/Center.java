package com.tms.adhyapan.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Center implements Serializable {
	
	private static final long serialVersionUID = -8985687385529874072L;
	
	@Id
	private Long id;
	private String name;
	private String address;
	private String spoc;
	private String contact;

}
