package com.tms.adhyapan.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class CommonUtils {

	public static List<String> getAlphabetList(){
		List<String> alphabetList = new ArrayList<String>();
		char ch;
		for (ch = 'A'; ch <= 'Z'; ch++) {
			alphabetList.add(String.valueOf(ch));
		}
		return alphabetList;
	}
	
	public static Date getDefaultEndDate() {
		Date endDate = null;
		try {
			endDate = new SimpleDateFormat(CommonConstants.DATE_FORMAT_DEFAULT).parse(CommonConstants.END_DATE_DEFAULT);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return endDate;
	}
	
	public static Date getCurrentSystemDate() {
		return new Date(System.currentTimeMillis());
	}
	
	public static String getDateAsFormat(Date date, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	
	public static List<String> getMonthList(Date startDate, Date endDate){
		List<String> monthList = new ArrayList<>();
		if(Objects.nonNull(startDate) && Objects.nonNull(endDate)) {
			String startDateStr = getDateAsFormat(startDate, CommonConstants.DATE_FORMAT_YYYY_MMM);
			String endDateStr = getDateAsFormat(endDate, CommonConstants.DATE_FORMAT_YYYY_MMM);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CommonConstants.DATE_FORMAT_YYYY_MMM, Locale.ENGLISH);
			YearMonth startYearMonth = YearMonth.parse(startDateStr, formatter);
		    YearMonth endYearMonth = YearMonth.parse(endDateStr, formatter);
		    while(startYearMonth.isBefore(endYearMonth)) {
		    	monthList.add(startYearMonth.format(formatter));
		    	startYearMonth = startYearMonth.plusMonths(1);
		    }
		    monthList.add(startYearMonth.format(formatter));
		}
	    return monthList;
	}
}
