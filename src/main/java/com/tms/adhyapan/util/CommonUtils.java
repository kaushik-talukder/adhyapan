package com.tms.adhyapan.util;

import java.util.ArrayList;
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
}
