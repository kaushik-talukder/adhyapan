package com.tms.adhyapan.vo;

import java.util.Date;

import lombok.Data;

@Data
public class DateRangeVO {
	private Date startDate;
	private Date endDate;

	public DateRangeVO(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
}
