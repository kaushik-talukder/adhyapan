package com.tms.adhyapan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
			endDate = new SimpleDateFormat(CommonConstants.DEFAULT_DATE_FORMAT).parse(CommonConstants.DEFAULT_END_DATE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return endDate;
	}
}
