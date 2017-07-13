package com.news.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {

	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String curDate = s.format(c.getTime());
		System.out.println(curDate);
	}

}
