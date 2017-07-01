package com.project.library.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MyDateUtil {
	
	
	public Date calculateDate(String currentDate, int daysToAdd) {

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			
			date = formatter.parse(currentDate);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();    
		c.setTime(date);
		c.add(Calendar.DATE, daysToAdd);
		
		return c.getTime();
	}
}
